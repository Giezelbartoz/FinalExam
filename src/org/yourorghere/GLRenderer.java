package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import static org.yourorghere.Objek.texture;

public class GLRenderer implements GLEventListener {

    private Random r = new Random();
    private float speed = (float) r.nextInt(10);
    private float kecepatan = 0;
    float varx = r.nextInt(3) + r.nextFloat();
    float varz = r.nextInt(5) + r.nextFloat();

    Texture texture;
    class vector {

        float x;
        float y;
        float z;

        public vector(float startX, float startY, float startZ) {
            x = startX;
            y = startY;
            z = startZ;
        }
    }

    vector vertikal = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun

    float Cx = 0, Cy = 2.5f, Cz = 0;
    float Lx = 0, Ly = 2.5f, Lz = -20f;

    boolean ori = true, silinder = false, silinder1 = false, silinder2 = false, silinder3 = false, silinder4 = false, silinder5 = false, silinder6 = false, silinder7 = false, silinder8 = false, silinder9 = false, silinder0 = false, kamera = false;

    public void init(GLAutoDrawable drawable) {

        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);
        float ambient[] = {1.0f,1.0f,1.0f,1.0f };
        float diffuse[] = {1.0f,1.0f,1.0f,1.0f };
        float position[] = {1.0f,1.0f,1.0f,0.0f };

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient,0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, diffuse,0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position,0);

//        gl.glEnable(GL.GL_CULL_FACE);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
//        gl.glDepthFunc(GL.GL_LEQUAL);

//        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
        
        try{ //deskripsi texture
            texture = TextureIO.newTexture(
                new File("E:\\Grafis\\TA\\Kapal_selam\\texture\\rock5.png"), //tempat file gambar
                true);
            System.out.println("adagambar");
        }catch(IOException e){
            System.out.println("Filenya nggak bisa di load"); //misal gambar gk ada
        }
        
        gl.glClearColor(0f, 0f, 1.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        //gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
    private static float ox = 0, oy = 5, oz = -15;
   // ini rotate
private static float ssx=0,ssy=0,ssz=0;
    private static boolean kananO, majuO, kiriO, atasO, bawahO;
    public void display(GLAutoDrawable drawable) {

         GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
       glu.gluLookAt(Cx, Cy+2, Cz,
                    Lx, Ly, Lz,
                  vertikal.x, vertikal.y, vertikal.z);
        
        gl.glPushMatrix();     
        //warna
        float amb1[]={0.05375f,0.05f,0.06625f,1.0f};
        float diff1[]={0.18275f,0.17f,0.22525f,1.0f};
        float spec1[]={0.332741f,0.328634f,0.346435f,1.0f};
        float shine=34.8f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,amb1,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,diff1,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,spec1,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        gl.glTranslatef(ox,oy-2,oz+2); 
        gl.glRotatef(ssx/1.5f, 1, 0 , 0);
        gl.glRotatef(ssy/1.5f, 0, 1 , 0);
        gl.glRotatef(ssz/1.5f, 0, 0 , 1);
        if(kananO){
            belok(-0.1f);
        }
        if(kiriO){
            belok(0.1f);
        }
        if(atasO){
            if (oy<8) {
            oy+=0.1f;Cy+=0.1f;Ly+=0.1f;
            }
            oz-=0.1f;Cz-=0.1f;Lz-=0.1f;
        }
        if(bawahO){
            if (oy>-8) {
            oy-=0.1f;Cy-=0.1f;Ly-=0.1f;
            }
            oz-=0.1f;Cz-=0.1f;Lz-=0.1f;
        }
        if (majuO) {
            oz-=0.1f;
            Cz-=0.1f;
        }
        Objek.kapal(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
        texture.enable();
        texture.bind();
        gl.glTranslatef(0, 0, -10);
        Objek.Bola(gl);
        texture.disable();
        gl.glPopMatrix();
        gl.glPushMatrix();
            Objek.BigBox(gl);
        gl.glPopMatrix();
        if(kamera)
            Key_Pressed(75);
                
        gl.glFlush();
    }
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
public void belok(float b){
        ox=(float) (ox-0.1*Math.sin((ssy+=b)*3.1415/180));
        oz=(float) (oz-0.1*Math.cos((ssy+=b)*3.1415/180));
        Cx=(float) (Cx-0.1*Math.sin((ssy+=b)*3.1415/180));
        Cz=(float) (Cz-0.1*Math.cos((ssy+=b)*3.1415/180));
        Lx=(float) (Lx-0.1*Math.sin((ssy+=b)*3.1415/180));
        Lz=(float) (Lz-0.1*Math.cos((ssy+=b)*3.1415/180));
    }
    void Key_Pressed(int keyCode) {
        //tombol spasi
        if(keyCode == 32){
            if (majuO) {
                majuO=false;
            }else{
                majuO=true;
            }
        }
        //panah kanan
         else if(keyCode == 39){
             if(kananO){
                 kananO=false;
             }else{
                 kiriO=false;
                 kananO=true;
             }
        }
        
         //panah kiri
         else if(keyCode == 37){
             if(kiriO){
                 kiriO=false;
             }else{
                 kananO=false;
                 kiriO=true;
             }
        }
        //panah atas
         else if(keyCode == 38){
            if(atasO){
                 atasO=false;
             }else{
                bawahO=false;
                 atasO=true;
             }
        }
         
        //panah bawah
        else if(keyCode == 40){
            if(bawahO){
                 bawahO=false;
             }else{
                atasO=false;
                 bawahO=true;
             }
        }
}
     
}