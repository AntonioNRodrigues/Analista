specification Natural 
	sorts
		Natural
		
	constructors
    	zero: --> Natural;
    	suc: Natural --> Natural;
    	make: int -->? Natural;
    	addLast: int --> Natural;
    	
	observers
   	 	sum: Natural Natural --> Natural;
   	 	mult: Natural Natural --> Natural;
   	 	//geq: Natural Natural --> boolean;
		
   	domains
   		i:int;
   		make(i) if i>=0;
   	axioms
  		I,J: Natural; i:int;
     
  		sum(zero(), I) = I;
  		sum(suc(I), J) = suc(sum(I,J));
   		 
   		mult(zero(), I) = zero();
  		mult(suc(I), J) = sum(mult(I,J),J);
  		
  		I=J if suc(I)=suc(J);
  		
  		make(i) = zero() when i=0 else suc(make(i-1));
	
  		//geq(I, J) = true when I = suc(J) else false;
  		//geq(J, I) = false when I = suc(J) else true;
end specification
