package jscip;

/** Minimal wrapper for a SCIP_COL pointer. */
public final class Column
{
   private final SWIGTYPE_p_SCIP_Col _colptr;

   public Column(SWIGTYPE_p_SCIP_Col colptr)
   {
      _colptr = colptr;
   }

   public SWIGTYPE_p_SCIP_Col getPtr()
   {
      return _colptr;
   }
}
