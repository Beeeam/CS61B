public class Body {
    public double Px;
    public double Py;
    public double Vx;
    public double Vy;
    public double m;
    public String img;
    public static final double G = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double mass, String imgFileName){
        Px = xP;
        Py = yP;
        Vx = xV;
        Vy = yV;
        m = mass;
        img = imgFileName;
    }
    public Body(Body B){
        Px = B.Px;
        Py = B.Py;
        Vx = B.Vx;
        Vy = B.Vy;
        m = B.m;
        img = B.img;
    }
    public double calDistance(Body b1){
        double dx = this.Px - b1.Px;
        double dy = this.Py - b1.Py;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }
    public double calcForceExertedBy(Body b1){
        double r = this.calDistance(b1);
        double F = G * b1.m * this.m / Math.pow(r, 2);
        return F;
    }
    public double calcForceExertedByX(Body b1){
        double dx = b1.Px - this.Px;
        double r = this.calDistance(b1);
        double F = this.calcForceExertedBy(b1);
        return F*dx/r;
    }
    public double calcForceExertedByY(Body b1){
        double dy = b1.Py - this.Py;
        double r = this.calDistance(b1);
        double F = this.calcForceExertedBy(b1);
        return F*dy/r;
    }
    public double calcNetForceExertedByX(Body[] bodys){
        double F=0;
        for (Body b:bodys){
            if(! this.equals(b)){
                F+=calcForceExertedByX(b);
            }
        }
        return F;
    }
    public double calcNetForceExertedByY(Body[] bodys){
        double F=0;
        for (Body b:bodys){
            if(! this.equals(b)){
                F+=calcForceExertedByY(b);
            }
        }
        return F;
    }
    public void update(double dt, double fx, double fy){
        double ax = fx/m;
        double ay = fy/m;
        Vx += ax * dt;
        Vy += ay * dt;
        Px += Vx * dt;
        Py += Vy * dt;
    }
    public void draw(){
        String dir = "images/";
        StdDraw.picture(Px, Py, dir+img);

    }
}
