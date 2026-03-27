package jscip;

/** Wrapper around a SCIP_EVENT pointer. */
public final class Event
{
   private final SWIGTYPE_p_SCIP_Event _eventptr;

   public Event(SWIGTYPE_p_SCIP_Event eventptr)
   {
      _eventptr = eventptr;
   }

   public SWIGTYPE_p_SCIP_Event getPtr()
   {
      return _eventptr;
   }

   public long getType()
   {
      assert(_eventptr != null);
      return SCIPJNI.SCIPeventGetType(_eventptr);
   }

   public boolean matches(long mask)
   {
      return EventMask.matches(getType(), mask);
   }

   public Variable getVar()
   {
      SWIGTYPE_p_SCIP_VAR ptr = SCIPJNI.SCIPeventGetVar(_eventptr);
      return (ptr == null) ? null : new Variable(ptr);
   }

   public double getOldObj()
   {
      return SCIPJNI.SCIPeventGetOldobj(_eventptr);
   }

   public double getNewObj()
   {
      return SCIPJNI.SCIPeventGetNewobj(_eventptr);
   }

   public double getOldBound()
   {
      return SCIPJNI.SCIPeventGetOldbound(_eventptr);
   }

   public double getNewBound()
   {
      return SCIPJNI.SCIPeventGetNewbound(_eventptr);
   }

   public SCIP_Vartype getOldType()
   {
      return SCIPJNI.SCIPeventGetOldtype(_eventptr);
   }

   public SCIP_Vartype getNewType()
   {
      return SCIPJNI.SCIPeventGetNewtype(_eventptr);
   }

   public Node getNode()
   {
      SWIGTYPE_p_SCIP_Node ptr = SCIPJNI.SCIPeventGetNode(_eventptr);
      return (ptr == null) ? null : new Node(ptr);
   }

   public Solution getSol()
   {
      SWIGTYPE_p_SCIP_SOL ptr = SCIPJNI.SCIPeventGetSol(_eventptr);
      return (ptr == null) ? null : new Solution(ptr);
   }

   public double getHoleLeft()
   {
      return SCIPJNI.SCIPeventGetHoleLeft(_eventptr);
   }

   public double getHoleRight()
   {
      return SCIPJNI.SCIPeventGetHoleRight(_eventptr);
   }

   public Row getRow()
   {
      SWIGTYPE_p_SCIP_Row ptr = SCIPJNI.SCIPeventGetRow(_eventptr);
      return (ptr == null) ? null : new Row(ptr);
   }

   public Column getRowCol()
   {
      SWIGTYPE_p_SCIP_Col ptr = SCIPJNI.SCIPeventGetRowCol(_eventptr);
      return (ptr == null) ? null : new Column(ptr);
   }

   public double getRowOldCoefVal()
   {
      return SCIPJNI.SCIPeventGetRowOldCoefVal(_eventptr);
   }

   public double getRowNewCoefVal()
   {
      return SCIPJNI.SCIPeventGetRowNewCoefVal(_eventptr);
   }

   public double getRowOldConstVal()
   {
      return SCIPJNI.SCIPeventGetRowOldConstVal(_eventptr);
   }

   public double getRowNewConstVal()
   {
      return SCIPJNI.SCIPeventGetRowNewConstVal(_eventptr);
   }

   public SCIP_SideType getRowSide()
   {
      return SCIPJNI.SCIPeventGetRowSide(_eventptr);
   }

   public double getRowOldSideVal()
   {
      return SCIPJNI.SCIPeventGetRowOldSideVal(_eventptr);
   }

   public double getRowNewSideVal()
   {
      return SCIPJNI.SCIPeventGetRowNewSideVal(_eventptr);
   }

   @Override
   public String toString()
   {
      return "event[type=" + getType() + "]";
   }
}
