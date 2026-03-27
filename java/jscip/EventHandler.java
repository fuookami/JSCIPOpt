package jscip;

/** High-level Java wrapper for SCIP event handlers. */
public abstract class EventHandler
{
   private ObjEventhdlr _objeventhdlr;
   private SWIGTYPE_p_SCIP_Eventhdlr _eventhdlrptr;

   protected EventHandler()
   {
      _objeventhdlr = null;
      _eventhdlrptr = null;
   }

   public abstract long getType();

   public void init(Scip scip, EventHandlerRef eventhdlr)
   {
   }

   public void exit(Scip scip, EventHandlerRef eventhdlr)
   {
   }

   public void initsol(Scip scip, EventHandlerRef eventhdlr)
   {
   }

   public void exitsol(Scip scip, EventHandlerRef eventhdlr)
   {
   }

   public void delete(Scip scip, EventHandlerRef eventhdlr)
   {
   }

   protected void free(Scip scip, EventHandlerRef eventhdlr)
   {
   }

   protected void close() throws Exception
   {
   }

   public abstract void execute(Scip scip, EventHandlerRef eventhdlr, Event event);

   public EventHandlerRef getRef()
   {
      return _eventhdlrptr == null ? null : new EventHandlerRef(_eventhdlrptr);
   }

   protected ObjEventhdlr getObjEventhdlr()
   {
      return _objeventhdlr;
   }

   static SWIGTYPE_p_SCIP_Eventhdlr getPtr(EventHandler obj)
   {
      return obj != null && obj._eventhdlrptr != null ? obj._eventhdlrptr : new SWIGTYPE_p_SCIP_Eventhdlr();
   }

   void attach(ObjEventhdlr objeventhdlr, SWIGTYPE_p_SCIP_Eventhdlr eventhdlrptr)
   {
      _objeventhdlr = objeventhdlr;
      _eventhdlrptr = eventhdlrptr;
   }

   void detach()
   {
      _objeventhdlr = null;
      _eventhdlrptr = null;
   }

   @Override
   public String toString()
   {
      return "event handler of type " + getClass().getName();
   }
}
