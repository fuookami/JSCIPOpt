package jscip;

/** Lightweight wrapper around a SCIP_EVENTHDLR pointer. */
public final class EventHandlerRef
{
   private final SWIGTYPE_p_SCIP_Eventhdlr _eventhdlrptr;

   public EventHandlerRef(SWIGTYPE_p_SCIP_Eventhdlr eventhdlrptr)
   {
      _eventhdlrptr = eventhdlrptr;
   }

   public SWIGTYPE_p_SCIP_Eventhdlr getPtr()
   {
      return _eventhdlrptr;
   }

   public String getName()
   {
      assert(_eventhdlrptr != null);
      return SCIPJNI.SCIPeventhdlrGetName(_eventhdlrptr);
   }

   @Override
   public String toString()
   {
      return getName();
   }
}
