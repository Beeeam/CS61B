public class NBody {
    //**read the radius */
    public static double readRadius(String inputfiles){
        In in = new In(inputfiles);
        int N = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    //**read the planets */
    public static Body[] readBodies(String inputfiles){
        In in = new In(inputfiles);
        int N = in.readInt();
        double radius = in.readDouble();
        Body[] bodies = new Body[N];
        for (int i = 0; i < N; i++){
            bodies[i] = new Body(0, 0, 0, 0, 0, "");
            bodies[i].Px = in.readDouble();
            bodies[i].Py = in.readDouble();
            bodies[i].Vx = in.readDouble();
            bodies[i].Vy = in.readDouble();
            bodies[i].m = in.readDouble();
            bodies[i].img = in.readString();
        }
        return bodies;    
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bodies = readBodies(filename);
        int num = bodies.length;
        StdDraw.enableDoubleBuffering();
        double t = 0;
        double[] xForces = new double[num];
        double[] yForces = new double[num];
        while (t<T){
            StdDraw.setScale(-radius,radius);
            StdDraw.clear();
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (int i = 0;i < num;i++){
                xForces[i]=bodies[i].calcNetForceExertedByX(bodies);
                yForces[i]=bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i = 0;i < num;i++){
                bodies[i].update(dt, xForces[i], yForces[i]);
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n",bodies.length);
        StdOut.printf("%.2e\n",radius);
        for (int i=0;i<bodies.length;i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            bodies[i].Px, bodies[i].Py, bodies[i].Vx,
            bodies[i].Vy, bodies[i].m, bodies[i].img);
        }
    }
}
