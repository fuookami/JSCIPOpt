import jscip.*;

/** Example how to register variable events manually from Java. */
public class VarEventDemo
{
   public static void main(String[] args)
   {
      System.loadLibrary("jscip");

      Scip scip = new Scip();
      scip.create("VarEventDemo");

      Variable x = scip.createVar("x", 0.0, 10.0, 3.0, SCIP_Vartype.SCIP_VARTYPE_INTEGER);
      Variable y = scip.createVar("y", 0.0, 10.0, 4.0, SCIP_Vartype.SCIP_VARTYPE_INTEGER);

      Constraint c1 = scip.createConsLinear("c1", new Variable[]{x, y}, new double[]{2.0, 1.0}, -scip.infinity(), 100.0);
      Constraint c2 = scip.createConsLinear("c2", new Variable[]{x, y}, new double[]{1.0, 2.0}, -scip.infinity(), 80.0);
      scip.addCons(c1);
      scip.addCons(c2);
      scip.releaseCons(c2);
      scip.releaseCons(c1);

      scip.includeEventHandler("watch-x-bounds", "prints bound changes for x", new EventHandler() {
         private int filterPos = -1;

         @Override
         public long getType()
         {
            return EventMask.DISABLED;
         }

         @Override
         public void init(Scip model, EventHandlerRef self)
         {
            filterPos = model.catchVarEvent(x, EventMask.BOUND_CHANGED, this);
         }

         @Override
         public void exit(Scip model, EventHandlerRef self)
         {
            if( filterPos >= 0 )
               model.dropVarEvent(x, EventMask.BOUND_CHANGED, this, filterPos);
         }

         @Override
         public void execute(Scip model, EventHandlerRef self, Event event)
         {
            Variable eventVar = event.getVar();
            System.out.println(self.getName() + ": "
                  + (eventVar == null ? "<null>" : eventVar.getName())
                  + " " + event.getOldBound() + " -> " + event.getNewBound());
         }
      });

      scip.solve();

      scip.releaseVar(y);
      scip.releaseVar(x);
      scip.free();
   }
}
