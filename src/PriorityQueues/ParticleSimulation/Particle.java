package PriorityQueues.ParticleSimulation;

public class Particle
{
    private double rx, ry;
    private double vx, vy;
    private final double radius;
    private final double mass;
    private int count;
    public Particle(double rx, double ry, double vx, double vy, double radius, double mass, int count) {
        this.rx = rx;
        this.ry = ry;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        this.mass = mass;
        this.count = count;
    }
    public void Move(double dt) { }
    public void Draw() { }
    public double TimeToHit(Particle that) {
        if (this == that) return -1;
        double dx = that.rx - this.rx, dy = that.ry - this.ry;
        double dvx = that.vx - this.vx, dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;
        if( dvdr > 0) return -1;
        double dvdv = dvx*dvx + dvy*dvy;
        double drdr = dx*dx + dy*dy;
        double sigma = this.radius + that.radius;
        double d = (dvdr*dvdr) - dvdv * (drdr - sigma*sigma);
        if (d < 0) return -1;
        return -(dvdr + Math.sqrt(d)) / dvdv;
    }
    public double TimeToHitVerticalWall() { return 0; }
    public double TimeToHitHorizontalWall() { return 0;}
    public void BounceOff(Particle that) {
        double dx = that.rx - this.rx, dy = that.ry - this.ry;
        double dvx = that.vx - this.vx, dvy = that.vy - this.vy;
        double dvdr = dx*dvx + dy*dvy;
        double dist = this.radius + that.radius;
        double J = 2 * this.mass * that.mass * dvdr / ((this.mass + that.mass) * dist);
        double Jx = J * dx / dist;
        double Jy = J * dy / dist;
        this.vx += Jx / this.mass;
        this.vy += Jy / this.mass;
        that.vx -= Jx / that.mass;
        that.vy -= Jy / that.mass;
        this.count++;
        that.count++;
    }
    public void BounceOffVerticalWall() {}
    public void BounceOffHorizontalWall() {}


}
