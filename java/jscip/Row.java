package jscip;

/** Minimal wrapper for a SCIP_ROW pointer. */
public final class Row
{
   private final SWIGTYPE_p_SCIP_Row _rowptr;

   public Row(SWIGTYPE_p_SCIP_Row rowptr)
   {
      _rowptr = rowptr;
   }

   public SWIGTYPE_p_SCIP_Row getPtr()
   {
      return _rowptr;
   }
}
