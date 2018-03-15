package PriorityQueues.ParticleSimulation;

public class ColisionEvent implements Comparable<ColisionEvent> {
    private double time;
    private Particle sourceParticle, destinationParticle;
    private int countA, countB;
    public ColisionEvent(double time, Particle a, Particle b) {
        this.sourceParticle =a;
        this.destinationParticle =b;
        this.time = time;
    }
    public int compareTo(ColisionEvent that) {
        return (int)(this.time - that.time);
    }
    public double getTime() {
        return this.time;
    }
    public Particle getSourceParticle() {
        return this.sourceParticle;
    }
    public Particle getDestinationParticle() {
        return this.destinationParticle;
    }
    public boolean IsValid() {
        return time > - 1;
    }
}
