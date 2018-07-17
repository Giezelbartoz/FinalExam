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

    static float puter = 0;

    static void kapal(GL gl) {
        gl.glRotatef(180, 0, 1, 0);
        //body
        float BODY_LENGTH = 5.0f;
        float BODY_RADIUS = 1.0f;
        //Set_Material(gl);
        int SLICES = 60;
        int STACKS = 60;
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();

        glu.gluCylinder(q, BODY_RADIUS, BODY_RADIUS, BODY_LENGTH, SLICES, STACKS);
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);

        //belakang
        double[] cutplane = new double[]{0.0f, 0.0f, 1.0f, 0.0f};
        gl.glPushMatrix();
        gl.glClipPlane(GL.GL_CLIP_PLANE2, cutplane, 0);
        gl.glEnable(GL.GL_CLIP_PLANE2);
        glu.gluSphere(q, BODY_RADIUS, SLICES, STACKS);
        gl.glDisable(GL.GL_CLIP_PLANE2);
        glu.gluDisk(q, 0, BODY_RADIUS, SLICES, STACKS);
        gl.glPopMatrix();
//
        //kubus atas
        gl.glTranslatef(-0.5f, 0.7f, -3f);
        // E, Bawah
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);         //a
        gl.glVertex3f(1f, 0, 0);      //b
        gl.glVertex3f(1f, 0, 1f);   //c
        gl.glVertex3f(0, 0, 1f);      //d
        gl.glEnd();
        gl.glPopMatrix();
        // F, Atas
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 1, 0);         //e
        gl.glVertex3f(1f, 1, 0);      //f
        gl.glVertex3f(1f, 1, 1f);   //g
        gl.glVertex3f(0, 1, 1f);      //h
        gl.glEnd();
        gl.glPopMatrix();
        // A, Depan
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);         //a
        gl.glVertex3f(1f, 0, 0);      //b
        gl.glVertex3f(1f, 1, 0);      //f
        gl.glVertex3f(0, 1, 0);         //e
        gl.glEnd();
        gl.glPopMatrix();
        // D, Belakang
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(1f, 0, 1f);   //c
        gl.glVertex3f(0, 0, 1f);      //d
        gl.glVertex3f(0, 1, 1f);      //h
        gl.glVertex3f(1f, 1, 1f);   //g
        gl.glEnd();
        gl.glPopMatrix();
        // B Kanan
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(1f, 0, 0);      //b
        gl.glVertex3f(1f, 0, 1f);   //c
        gl.glVertex3f(1f, 1, 1f);   //g
        gl.glVertex3f(1f, 1, 0);      //f
        gl.glEnd();
        gl.glPopMatrix();
        // C, Kiri
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);         //a
        gl.glVertex3f(0, 0, 1f);      //d
        gl.glVertex3f(0, 1, 1f);      //h
        gl.glVertex3f(0, 1, 0);         //e
        gl.glEnd();
        gl.glPopMatrix();
//
        //silinder atas 1
        gl.glTranslatef(0.4999f, 1f, 0.9f);
        gl.glPushMatrix();
        float BODY_LENGTH2 = 1.1f;
        float BODY_RADIUS2 = 0.5f;
        //Set_Material(gl);
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
//
        //lingkaran belakang
        gl.glTranslatef(0f, 1.3f, 4f);
        glu.gluCylinder(q, 0.5, 0.5, 0.2, SLICES, STACKS);
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.0f, 0.0f, 0.5f);

        //baling-baling
//        gl.glRotatef(puter, 0, 0, 1);
        gl.glTranslatef(0f, 0f, -0.4f);
        gl.glPushMatrix();
        gl.glRotatef(90 + puter, 0, 0, 1);
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0.4f, 0f, 0f);
        gl.glVertex3f(0.4f, 0.1f, 0);
        gl.glVertex3f(0f, 0.1f, 0f);
        gl.glVertex3f(0f, 0, 0);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, 0f);
        gl.glRotatef(0 + puter, 0, 0, 1);
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0.4f, 0f, 0f);
        gl.glVertex3f(0.4f, 0.1f, 0);
        gl.glVertex3f(0f, 0.1f, 0f);
        gl.glVertex3f(0f, 0, 0);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glRotatef(180 + puter, 0, 0, 1);
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0f, 0, 0);
        gl.glVertex3f(0f, 0.1f, 0f);
        gl.glVertex3f(0.4f, 0.1f, 0);
        gl.glVertex3f(0.4f, 0f, 0f);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glRotatef(270 + puter, 0, 0, 1);
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(0f, 0, 0);
        gl.glVertex3f(0f, 0.1f, 0f);
        gl.glVertex3f(0.4f, 0.1f, 0);
        gl.glVertex3f(0.4f, 0f, 0f);
        gl.glEnd();
        gl.glPopMatrix();
        puter -= 9f;

        //sirip bawah
        gl.glTranslatef(-0.5f, 0f, -2f);
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0, 0);
        gl.glVertex3f(-1f, 0f, 1f);
        gl.glVertex3f(2f, 0f, 1f);
        gl.glVertex3f(2f, 0, 0);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0, 0);
        gl.glVertex3f(-1f, 0.1f, 1f);
        gl.glVertex3f(2f, 0.1f, 1f);
        gl.glVertex3f(2f, 0, 0);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0, 1f);
        gl.glVertex3f(-1f, 0.1f, 1.2f);
        gl.glVertex3f(2f, 0.1f, 1.2f);
        gl.glVertex3f(2f, 0, 1f);
        gl.glEnd();
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3f(-1f, 0.1f, 1f);
        gl.glVertex3f(-1f, 0.1f, 1.2f);
        gl.glVertex3f(2f, 0.1f, 1.2f);
        gl.glVertex3f(2f, 0.1f, 1f);
        gl.glEnd();
        gl.glPopMatrix();

        //antena 1
        gl.glTranslatef(0.5f, 0f, -1.9f);
        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        glu.gluCylinder(q, 0.03, 0.03, 2.6, SLICES2, STACKS2);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glTranslatef(0f, 0f, 0.1f);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glPopMatrix();
//
        //antena 2
        gl.glTranslatef(0f, 0f, 0.2f);
        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        glu.gluCylinder(q, 0.03, 0.03, 2.7, SLICES2, STACKS2);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glTranslatef(0f, 0f, 0.1f);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glPopMatrix();
//
        //antena 3
        gl.glTranslatef(0f, 0f, 0.2f);
        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        glu.gluCylinder(q, 0.03, 0.03, 2.5, SLICES2, STACKS2);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glTranslatef(0f, 0f, 0.1f);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glPopMatrix();

        //antena 4
        gl.glTranslatef(0f, 0f, 0.2f);
        gl.glPushMatrix();
        gl.glRotatef(90, 1, 0, 0);
        glu.gluCylinder(q, 0.03, 0.03, 2.4, SLICES2, STACKS2);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glTranslatef(0f, 0f, 0.1f);
        glu.gluDisk(q, 0.0f, 0.03, SLICES2, STACKS2);
        gl.glPopMatrix();
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

    static void BigBox(GL gl) {
        float amb[] = {0, 0f, 1, 1};
        float diff[] = {0, 0f, 1, 1};
        float spec[] = {0, 0f, 1, 1};
        float shine = 0;

        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(-10000, 0, -10000);
        gl.glVertex3f(10000, 0, -10000);
        gl.glVertex3f(10000, 0, 10000);
        gl.glVertex3f(-10000, 0, 10000);
        gl.glEnd();
    }
}
