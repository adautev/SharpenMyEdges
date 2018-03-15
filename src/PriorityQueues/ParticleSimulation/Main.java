package PriorityQueues.ParticleSimulation;

import PriorityQueues.BinaryHeapMinPriorityQueue;

public class Main {
    private static BinaryHeapMinPriorityQueue<ColisionEvent> pq;
    private static double t = 0.0;
    private static Particle[] particles;
    private static int numberOfParticles = 2;
    public static void main(String[] args) throws Exception {
        pq = new BinaryHeapMinPriorityQueue<>(numberOfParticles);
        for(int i = 0; i < numberOfParticles; i++) {
            Predict(particles[i]);
        }
        pq.Insert(new ColisionEvent(0, null, null));
        while(!pq.isEmpty())
        {
            ColisionEvent event = pq.DeleteMinimum();
            if(!event.IsValid()) continue;
            Particle a = event.getSourceParticle();
            Particle b = event.getDestinationParticle();
            for(int i = 0; i < numberOfParticles; i++)
                particles[i].Move(event.getTime() - t);
            t = event.getTime();
            if(a != null && b != null) a.BounceOff(b);
            if(a != null && b == null) a.BounceOffVerticalWall();
            if(a == null && b != null) b.BounceOffHorizontalWall();
            else Redraw();
            Predict(a);
            Predict(b);
        }

    }

    private static void Redraw() {
    }

    private static void Predict(Particle a)
    {
        if (a == null) return;
        for (int i = 0; i < numberOfParticles; i++)
        {
            double dt = a.TimeToHit(particles[i]);
            pq.Insert(new ColisionEvent(t + dt, a, particles[i]));
        }
        pq.Insert(new ColisionEvent(t + a.TimeToHitVerticalWall() , a, null));
        pq.Insert(new ColisionEvent((t + a.TimeToHitHorizontalWall()), null, a));
    }
}
