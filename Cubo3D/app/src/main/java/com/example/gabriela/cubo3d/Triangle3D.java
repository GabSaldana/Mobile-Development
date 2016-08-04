package com.example.gabriela.cubo3d;

import android.content.Context;
import android.graphics.*;
import android.view.*;


public class Triangle3D extends View{

    int centerX, centerY, maxX, maxY, minMaxXY;
    Obj obj;
    Paint pn;

    public Triangle3D(Context c){
        super(c);
        centerX = 0; centerY = 0;
        pn = new Paint();
        obj = new Obj();
    }

    @Override
    public void onDraw(Canvas g){

        pn.setColor(Color.parseColor("#F5F5F5"));
        pn.setStyle(Paint.Style.FILL); //fill the background with blue color
        g.drawRect(0,0,getWidth(),getHeight(),pn);
        pn.setColor(Color.parseColor("#82B1FF"));
        pn.setStrokeWidth(10);
        maxX    = getWidth()-1; maxY = getHeight()-1; minMaxXY = Math.min(maxX, maxY);
        centerX = maxX/2;
        centerY = maxY/2;
        obj.d = obj.rho*minMaxXY/obj.objSize;
        obj.eyeAndScreen();
        line(g, 0, 1); line(g, 1, 2); line(g, 2, 3); line(g, 3, 0); // aristas horizontales inferiores
        line(g, 1, 4); line(g, 2, 4); line(g, 3, 4); line(g, 0, 4); // cara inferior
        //line(g, 0, 4); line(g, 1, 4); line(g, 2, 4); line(g, 3, 4); // aristas horizontales superiores
    }
    int iX(float x)
    {
        return Math.round(centerX + x);
    }
    int iY(float y)
    {
        return Math.round(centerY - y);
    }
    void line(Canvas g, int i, int j){
        Point2D p = obj.vScr[i], q = obj.vScr[j];
        g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y), pn);
    }
    @Override
    public boolean onTouchEvent(MotionEvent e){
        if(e.getAction() == MotionEvent.ACTION_MOVE){
            obj.theta   = (float) getWidth() / e.getX();
            obj.phi     = (float) getHeight() / e.getY();
            obj.rho     = (obj.phi/obj.theta) * getHeight();
            centerX     = (int)e.getX();
            centerY     = (int)e.getY();
        }
        invalidate();
        return true;
    }
}
class ObjT{              // Posee los datos del objeto 3D
    float rho, theta=0.3F, phi=1.3F, d, objSize, v11, v12, v13, v21, v22, v23, v32, v33, v43; // elementos de la matriz V
    Point3D [] w;       // coordenadas universales
    Point2D [] vScr;    // coordenadas de la pantalla
    ObjT() {             // Cambiar las coordenadas x,y,z para construir Prisma, Cilindro, Pirámide, Cono y Esfera.
        w	= new Point3D[8];
        vScr	= new Point2D[8];
        w[0]	= new Point3D( 1, -1, -1);  // desde la base
        w[1]	= new Point3D( 1,  1, -1);
        w[2]	= new Point3D(-1,  1, -1);
        w[3]	= new Point3D(-1, -1, -1);
        w[4]	= new Point3D(200, 100, 0);

        objSize = (float) Math.sqrt(12F);   // = sqrt(2*2 + 2*2 + 2*2) es la distancia entre dos vertices opuestos
        rho	= objSize*5;                    // para cambiar la perspectiva
    }
    void initPersp(){
        float costh = (float)Math.cos(theta), sinth=(float)Math.sin(theta), cosph=(float)Math.cos(phi), sinph=(float)Math.sin(phi);
        v11 = -sinth; v12 = -cosph*costh; v13 = sinph*costh;
        v21 = costh;  v22 = -cosph*sinth; v23 = sinph*sinth;
        v32 = sinph;  v33 = cosph;        v43 = -rho;
    }
    void eyeAndScreen(){
        initPersp();
        for(int i = 0; i < 8; i++){
            Point3D p = w[i];
            float x = v11*p.x + v21*p.y, y = v12*p.x + v22*p.y + v32*p.z, z = v13*p.x + v23*p.y + v33*p.z + v43;
            vScr[i] = new Point2D(-d*x/z, -d*y/z);
        }
    }
}
class Point2DT{
    float x, y;
    Point2DT(float x, float y){
        this.x = x;
        this.y = y;
    }
}
class Point3DT{
    float x, y, z;
    Point3DT(double x, double y, double z){
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }
}
