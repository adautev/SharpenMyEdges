package PriorityQueues.ParticleSimulation;

import PriorityQueues.BinaryHeapMinPriorityQueue;

public class Main {
    private static BinaryHeapMinPriorityQueue<ColisionEvent> pq;
    private static double t = 0.0;
    private static Particle[] particles;
    private static int numberOfParticles = 2;
    private static double firstVerticalWallX = 0;
    private static double secondVerticalWallX = 100;
    private static double firstHorizontalWallY = 0;
    private static double secondHorizontalWallY = 100;
    public static void main(String[] args) throws Exception {
        particles = new Particle[] {
                new Particle(1,2,3,3, 4, 5, 0),
                new Particle(5,2,3,3, 4, 5, 0),
        };
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
//            if(a != null && b == null) a.BounceOffVerticalWall(firstVerticalWallX, secondVerticalWallX);
//            if(a == null && b != null) b.BounceOffHorizontalWall();
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
//        pq.Insert(new ColisionEvent(t + a.TimeToHitVerticalWall() , a, null));
//        pq.Insert(new ColisionEvent((t + a.TimeToHitHorizontalWall()), null, a));
    }

}
