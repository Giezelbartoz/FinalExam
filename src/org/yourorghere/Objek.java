package org.yourorghere;

import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Objek {


    

    static float putar = 0;

    static void kapal(GL gl) {
        gl.glRotatef(180, 0, 1, 0);

        //badannyaaa
        float BODY_LENGTH = 5.0f;
        float BODY_RADIUS = 1.0f;

        int SLICES = 60;
        int STACKS = 60;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();

        glu.gluCylinder(q, BODY_RADIUS, BODY_RADIUS, BODY_LENGTH, SLICES, STACKS);
        gl.glNormal3f(0, 0, 1.0f);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);

        //tabung belakang
        double[] cutplane = new double[]{0.0f, 0.0f, 1.0f, 0.0f};
        gl.glPushMatrix();
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, BODY_RADIUS, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        glu.gluDisk(q, 0, BODY_RADIUS, SLICES, STACKS);
        gl.glPopMatrix();

        //kubus atas
        gl.glTranslatef(-0.5f, 0.7f, -3f);
        //E, bawah
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(1f, 0, 0);
        gl.glVertex3f(1f, 0, 1f);
        gl.glVertex3f(0, 0, 1f);
        gl.glEnd();
        gl.glPopMatrix();
        //F , BAWAH
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 1, 0);
        gl.glVertex3f(1f, 1, 0);
        gl.glVertex3f(1f, 1, 1f);
        gl.glVertex3f(0, 1, 1f);
        gl.glEnd();
        gl.glPopMatrix();
        //A,Depan
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(1f, 0, 0);
        gl.glVertex3f(1f, 1, 1f);
        gl.glVertex3f(0, 1, 1f);
        gl.glEnd();
        gl.glPopMatrix();
        //d, belakang
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(1f, 0, 1f); //sisi b
        gl.glVertex3f(0, 0, 1f);  //sisi c
        gl.glVertex3f(0, 1, 1f); //sisi g
        gl.glVertex3f(1f, 1, 1f); //sisi f
        gl.glEnd();
        gl.glPopMatrix();

        //B kanan
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(1f, 0, 0);
        gl.glVertex3f(1f, 0, 1f);
        gl.glVertex3f(1f, 1, 1f);
        gl.glVertex3f(1f, 1, 0);
        gl.glEnd();
        gl.glPopMatrix();

        //C kiri
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(0, 0, 1f);
        gl.glVertex3f(0, 1, 1f);
        gl.glVertex3f(0, 1, 1);
        gl.glEnd();
        gl.glPopMatrix();

        //silinder atas 1
        gl.glTranslatef(0.4999f, 1f, 0.9f);
        gl.glPushMatrix();
        float BODY_LENGTH2 = 1.1f;
        float BODY_RADIUS2 = 0.5f;

        //Set_Material(gl);


        //set material(gl)

        int SLICES2 = 60;
        int STACKS2 = 60;
        gl.glRotatef(90, 1, 0, 0);
        glu.gluCylinder(q, BODY_RADIUS2, BODY_RADIUS2, BODY_LENGTH2, SLICES2, STACKS2);
        glu.gluDisk(q, 0.0f, BODY_RADIUS2, SLICES2, STACKS2);
        gl.glTranslatef(0f, 0f, BODY_RADIUS2);
        glu.gluDisk(q, 0.0f, BODY_RADIUS2, SLICES2, STACKS2);
        gl.glPopMatrix();

//
        //silinder atas 2
        gl.glTranslatef(0f, 0f, -0.8f);
        gl.glPushMatrix();
        //Set_Material(gl);
        gl.glRotatef(90, 1, 0, 0);
        glu.gluCylinder(q, BODY_RADIUS2, BODY_RADIUS2, BODY_LENGTH2, SLICES2, STACKS2);
        glu.gluDisk(q, 0.0f, BODY_RADIUS2, SLICES2, STACKS2);
        gl.glTranslatef(0f, 0f, BODY_RADIUS2);
        glu.gluDisk(q, 0.0f, BODY_RADIUS2, SLICES2, STACKS2);
        gl.glPopMatrix();
//
        //depan
        gl.glTranslatef(0f, -1.7f, -2.1f);
        gl.glRotatef(180, 1, 0, 0);
        gl.glPushMatrix();
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, BODY_RADIUS, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        glu.gluDisk(q, 0, BODY_RADIUS, SLICES, STACKS);
        gl.glPopMatrix();
        
         //sirip atas
        gl.glTranslatef(0f, -1.3f, -3f);
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0, 0);
        gl.glVertex3f(-1f, 0f, 1f);
        gl.glVertex3f(1f, 0f, 1f);
        gl.glVertex3f(1f, 0, 0);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0, 0);
        gl.glVertex3f(-1f, 0.1f, 1f);
        gl.glVertex3f(1f, 0.1f, 1f);
        gl.glVertex3f(1f, 0, 0);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0, 1f);
        gl.glVertex3f(-1f, 0.1f, 1.2f);
        gl.glVertex3f(1f, 0.1f, 1.2f);
        gl.glVertex3f(1f, 0, 1f);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0.1f, 1f);
        gl.glVertex3f(-1f, 0.1f, 1.2f);
        gl.glVertex3f(1f, 0.1f, 1.2f);
        gl.glVertex3f(1f, 0.1f, 1f);
        gl.glEnd();
        gl.glPopMatrix();

    }
    static void Tabung(GL gl) {
        float amb[] = {0.34f, 0.34f, 0.34f, 1};
        float diff[] = {0.41f, 0.41f, 0.41f, 1};
        float spec[] = {0.11f, 0.11f, 0.11f, 1};
        float shine = 200;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

        float BODY_LENGTH = 5f;
        float BODY_RADIUS = 2.0f;
        int SLICES = 30;
        int STACKS = 30;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();

        glu.gluCylinder(q, BODY_RADIUS, BODY_RADIUS, BODY_LENGTH, SLICES, STACKS);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
    }
     static void Bola(GL gl) {

        float BODY_RADIUS = 2.0f;
        int SLICES = 30;
        int STACKS = 30;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();

        glu.gluSphere(q, BODY_RADIUS, SLICES, STACKS);
    }
    public static Texture texture;
    static void Bigbox(GL gl) {
        float amb[] = {0, 0.5f, 0, 1};
        float diff[] = {0, 0.5f, 0, 1};
        float spec[] = {0, 0.5f, 0, 1};
        float shine = 0;
        
        gl.glMaterialfv(GL.GL_FRONT,GL.GL_AMBIENT,amb,0);
        gl.glMaterialfv(GL.GL_FRONT,GL.GL_DIFFUSE,diff,0);
        gl.glMaterialfv(GL.GL_FRONT,GL.GL_SPECULAR,spec,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-10000, 0, -10000);
        gl.glVertex3f(10000, 0, -10000);
        gl.glVertex3f(10000, 0, 10000);
        gl.glVertex3f(-10000, 0, -10000);
        gl.glEnd();

    }

}
