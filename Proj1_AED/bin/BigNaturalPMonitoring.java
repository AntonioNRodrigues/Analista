//THIS FILE WAS AUTOMATICALLY GENERATED BY ConGu v2.00.
/*
 * Faculdade de Ciencias da Universidade de Lisboa
 * Bloco C6, piso 3, sala 32
 * Campo Grande, 1749-016 Lisboa
 * Portugal
 *
 * Project <a href="http://gloss.di.fc.ul.pt/quest">Contract Guided System Development</a>.
 */



import runtime.utils.*;
import runtime.exceptions.*;

public class BigNaturalPMonitoring {
	private static final ConguRange<BigNatural> _domain_BigNatural = new ConguRange<BigNatural>(BigNatural.class);

	public static void BigNatural(BigNatural thisObj, boolean isMonitoring, boolean executeMethod) {
		//RUN METHOD
		if (executeMethod)
			thisObj.BigNatural_CONGU();

		//RUN POS
		if (isMonitoring)
			BigNatural_POST_CONDITION(thisObj);

		if (isMonitoring) {

			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}


	}

	public static void BigNatural_POST_CONDITION(BigNatural thisObj) {
		//(sum(zero(), I) = I);
		for (BigNatural I_6 : _domain_BigNatural) {
			try {
				BigNatural __CTOR_0 = null;
				boolean __CTOR_0_HAS_RUN = false;
				BigNatural __VAR_1 = null;
				boolean __VAR_1_HAS_RUN = false;
				//TARGET
				__CTOR_0 = ((BigNatural)thisObj);
				__CTOR_0_HAS_RUN = true;
				//RETURNS RESULT
				__VAR_1 = BigNaturalPMonitoring.sum(((BigNatural)__CTOR_0), ((BigNatural)I_6), false);
				__VAR_1_HAS_RUN = true;
				boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__VAR_1), ((BigNatural)I_6), false));
				if (!__CONGU_ASSERT_RESULT) {
					java.util.Map<String, String> __CONTEXT_VARIABLES_2 = new java.util.HashMap<String, String>(); {
						__CONTEXT_VARIABLES_2.put("I : Natural;*", I_6+"");
					}
					java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_2 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
						if (__CTOR_0_HAS_RUN)
							__CONTEXT_TERMS_2.add(new runtime.utils.ConguContextMethodCall("zero()", __CTOR_0+""));
						if (__VAR_1_HAS_RUN)
							__CONTEXT_TERMS_2.add(new runtime.utils.ConguContextMethodCall("sum(zero(), I)", __VAR_1+""));
					}
					MethodContext __METHOD_CONTEXT_2 = new MethodContext(false, "(sum(zero(), I) = I);", __CONTEXT_VARIABLES_2, __CONTEXT_TERMS_2, "BigNatural");
					throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_2);
				}
			} catch (ConguException __ce) {
				throw __ce;
			} catch (Exception __e) {
			}
		}

		//(mult(zero(), I) = zero());
		for (BigNatural I_7 : _domain_BigNatural) {
			try {
				BigNatural __CTOR_2 = null;
				boolean __CTOR_2_HAS_RUN = false;
				BigNatural __VAR_3 = null;
				boolean __VAR_3_HAS_RUN = false;
				BigNatural __CTOR_4 = null;
				boolean __CTOR_4_HAS_RUN = false;
				//TARGET
				__CTOR_2 = ((BigNatural)thisObj);
				__CTOR_2_HAS_RUN = true;
				//RETURNS RESULT
				__VAR_3 = BigNaturalPMonitoring.mult(((BigNatural)__CTOR_2), ((BigNatural)I_7), false);
				__VAR_3_HAS_RUN = true;
				//CONSTRUCTOR
				__CTOR_4 = new BigNatural(new runtime.utils.ConguParam());
				__CTOR_4_HAS_RUN = true;
				//RETURNS THIS
				BigNaturalPMonitoring.BigNatural(((BigNatural)__CTOR_4), false, true);
				__CTOR_4_HAS_RUN = true;
				boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__VAR_3), ((BigNatural)__CTOR_4), false));
				if (!__CONGU_ASSERT_RESULT) {
					java.util.Map<String, String> __CONTEXT_VARIABLES_3 = new java.util.HashMap<String, String>(); {
						__CONTEXT_VARIABLES_3.put("I : Natural;*", I_7+"");
					}
					java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_3 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
						if (__CTOR_2_HAS_RUN)
							__CONTEXT_TERMS_3.add(new runtime.utils.ConguContextMethodCall("zero()", __CTOR_2+""));
						if (__VAR_3_HAS_RUN)
							__CONTEXT_TERMS_3.add(new runtime.utils.ConguContextMethodCall("mult(zero(), I)", __VAR_3+""));
						if (__CTOR_4_HAS_RUN)
							__CONTEXT_TERMS_3.add(new runtime.utils.ConguContextMethodCall("zero()", __CTOR_4+""));
					}
					MethodContext __METHOD_CONTEXT_3 = new MethodContext(false, "(mult(zero(), I) = zero());", __CONTEXT_VARIABLES_3, __CONTEXT_TERMS_3, "BigNatural");
					throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_3);
				}
			} catch (ConguException __ce) {
				throw __ce;
			} catch (Exception __e) {
			}
		}
	}


	public static BigNatural suc(BigNatural thisObj, boolean isMonitoring) {
		//PUTS
		if (isMonitoring) {
			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}

		//VARIABLE CLONING
		BigNatural thisObjOld = (BigNatural)clone(thisObj, false);

		//RUN METHOD
		BigNatural result = thisObj.suc_CONGU();

		//RUN POS
		if (isMonitoring)
			suc_POST_CONDITION(thisObj, thisObjOld, result);

		if (isMonitoring) {

			_domain_BigNatural.put(result != null ? result : null);
		}


		return result;

	}

	public static void suc_POST_CONDITION(BigNatural thisObj, BigNatural thisObjOld, BigNatural result) {
		if (result != null) {
			//(sum(suc(I), J) = suc(sum(I, J)));
			for (BigNatural J_9 : _domain_BigNatural) {
				try {
					if (J_9.getClass() == thisObjOld.getClass()) {
						BigNatural __TARGET_RESULT_0 = null;
						boolean __TARGET_RESULT_0_HAS_RUN = false;
						BigNatural __VAR_1 = null;
						boolean __VAR_1_HAS_RUN = false;
						BigNatural __VAR_2 = null;
						boolean __VAR_2_HAS_RUN = false;
						BigNatural __VAR_3 = null;
						boolean __VAR_3_HAS_RUN = false;
						//TARGET
						__TARGET_RESULT_0 = ((BigNatural)result);
						__TARGET_RESULT_0_HAS_RUN = true;
						//RETURNS RESULT
						__VAR_1 = BigNaturalPMonitoring.sum(((BigNatural)__TARGET_RESULT_0), ((BigNatural)J_9), false);
						__VAR_1_HAS_RUN = true;
						//RETURNS RESULT
						__VAR_2 = BigNaturalPMonitoring.sum(((BigNatural)thisObjOld), ((BigNatural)J_9), false);
						__VAR_2_HAS_RUN = true;
						//RETURNS RESULT
						__VAR_3 = BigNaturalPMonitoring.suc(((BigNatural)__VAR_2), false);
						__VAR_3_HAS_RUN = true;
						boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__VAR_1), ((BigNatural)__VAR_3), false));
						if (!__CONGU_ASSERT_RESULT) {
							java.util.Map<String, String> __CONTEXT_VARIABLES_4 = new java.util.HashMap<String, String>(); {
								__CONTEXT_VARIABLES_4.put("J : Natural;*", J_9+"");
								__CONTEXT_VARIABLES_4.put("I : Natural;*", thisObjOld+"");
							}
							java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_4 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
								if (__TARGET_RESULT_0_HAS_RUN)
									__CONTEXT_TERMS_4.add(new runtime.utils.ConguContextMethodCall("suc(I)", __TARGET_RESULT_0+""));
								if (__VAR_1_HAS_RUN)
									__CONTEXT_TERMS_4.add(new runtime.utils.ConguContextMethodCall("sum(suc(I), J)", __VAR_1+""));
								if (__VAR_2_HAS_RUN)
									__CONTEXT_TERMS_4.add(new runtime.utils.ConguContextMethodCall("sum(I, J)", __VAR_2+""));
								if (__VAR_3_HAS_RUN)
									__CONTEXT_TERMS_4.add(new runtime.utils.ConguContextMethodCall("suc(sum(I, J))", __VAR_3+""));
							}
							MethodContext __METHOD_CONTEXT_4 = new MethodContext(false, "(sum(suc(I), J) = suc(sum(I, J)));", __CONTEXT_VARIABLES_4, __CONTEXT_TERMS_4, "BigNatural");
							throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_4);
						}
					}
				} catch (ConguException __ce) {
					throw __ce;
				} catch (Exception __e) {
				}
			}

			//(mult(suc(I), J) = sum(mult(I, J), J));
			for (BigNatural J_12 : _domain_BigNatural) {
				try {
					if (J_12.getClass() == thisObjOld.getClass()) {
						BigNatural __TARGET_RESULT_4 = null;
						boolean __TARGET_RESULT_4_HAS_RUN = false;
						BigNatural __VAR_5 = null;
						boolean __VAR_5_HAS_RUN = false;
						BigNatural __VAR_6 = null;
						boolean __VAR_6_HAS_RUN = false;
						BigNatural __VAR_7 = null;
						boolean __VAR_7_HAS_RUN = false;
						//TARGET
						__TARGET_RESULT_4 = ((BigNatural)result);
						__TARGET_RESULT_4_HAS_RUN = true;
						//RETURNS RESULT
						__VAR_5 = BigNaturalPMonitoring.mult(((BigNatural)__TARGET_RESULT_4), ((BigNatural)J_12), false);
						__VAR_5_HAS_RUN = true;
						//RETURNS RESULT
						__VAR_6 = BigNaturalPMonitoring.mult(((BigNatural)thisObjOld), ((BigNatural)J_12), false);
						__VAR_6_HAS_RUN = true;
						//RETURNS RESULT
						__VAR_7 = BigNaturalPMonitoring.sum(((BigNatural)__VAR_6), ((BigNatural)J_12), false);
						__VAR_7_HAS_RUN = true;
						boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__VAR_5), ((BigNatural)__VAR_7), false));
						if (!__CONGU_ASSERT_RESULT) {
							java.util.Map<String, String> __CONTEXT_VARIABLES_5 = new java.util.HashMap<String, String>(); {
								__CONTEXT_VARIABLES_5.put("J : Natural;*", J_12+"");
								__CONTEXT_VARIABLES_5.put("I : Natural;*", thisObjOld+"");
							}
							java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_5 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
								if (__TARGET_RESULT_4_HAS_RUN)
									__CONTEXT_TERMS_5.add(new runtime.utils.ConguContextMethodCall("suc(I)", __TARGET_RESULT_4+""));
								if (__VAR_5_HAS_RUN)
									__CONTEXT_TERMS_5.add(new runtime.utils.ConguContextMethodCall("mult(suc(I), J)", __VAR_5+""));
								if (__VAR_6_HAS_RUN)
									__CONTEXT_TERMS_5.add(new runtime.utils.ConguContextMethodCall("mult(I, J)", __VAR_6+""));
								if (__VAR_7_HAS_RUN)
									__CONTEXT_TERMS_5.add(new runtime.utils.ConguContextMethodCall("sum(mult(I, J), J)", __VAR_7+""));
							}
							MethodContext __METHOD_CONTEXT_5 = new MethodContext(false, "(mult(suc(I), J) = sum(mult(I, J), J));", __CONTEXT_VARIABLES_5, __CONTEXT_TERMS_5, "BigNatural");
							throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_5);
						}
					}
				} catch (ConguException __ce) {
					throw __ce;
				} catch (Exception __e) {
				}
			}
		}
	}


	public static void BigNatural(BigNatural thisObj, int a, boolean isMonitoring, boolean executeMethod) {
		//VARIABLE CLONING
		int aOld = ((Integer)a);

		//RUN PRE
		if (isMonitoring)
			BigNatural_PRE_CONDITION(a);

		//RUN METHOD
		if (executeMethod)
			thisObj.BigNatural_CONGU(a);

		//RUN POS
		if (isMonitoring)
			BigNatural_POST_CONDITION(thisObj, aOld);

		if (isMonitoring) {

			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}


	}

	public static void BigNatural_PRE_CONDITION(int a) {
		//make(i) if (i >= 0);
		try {
			boolean __CONGU_ASSERT_RESULT = ((Boolean)(((Integer)a) >= 0));
			if (!__CONGU_ASSERT_RESULT) {
				java.util.Map<String, String> __CONTEXT_VARIABLES_1 = new java.util.HashMap<String, String>(); {
					__CONTEXT_VARIABLES_1.put("i : int;*", a+"");
				}
				java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_1 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
				}
				MethodContext __METHOD_CONTEXT_1 = new MethodContext(true, "make(i) if (i >= 0);", __CONTEXT_VARIABLES_1, __CONTEXT_TERMS_1, "BigNatural");
				throw new runtime.exceptions.PreconditionException(__METHOD_CONTEXT_1);
			}
		} catch (ConguException __ce) {
			throw __ce;
		} catch (Exception __e) {
		}
	}

	public static void BigNatural_POST_CONDITION(BigNatural thisObj, int a) {
		//make(i) = zero() when (i = 0) else suc(make((i - 1)));
		try {
			BigNatural __CTOR_0 = null;
			boolean __CTOR_0_HAS_RUN = false;
			BigNatural __CTOR_1 = null;
			boolean __CTOR_1_HAS_RUN = false;
			BigNatural __CTOR_2 = null;
			boolean __CTOR_2_HAS_RUN = false;
			BigNatural __VAR_3 = null;
			boolean __VAR_3_HAS_RUN = false;
			boolean __WHEN_RESULT_0 = ((Boolean)((Integer)a).equals(0));
			if (__WHEN_RESULT_0) {
				//TARGET
				__CTOR_0 = ((BigNatural)thisObj);
				__CTOR_0_HAS_RUN = true;
				//CONSTRUCTOR
				__CTOR_1 = new BigNatural(new runtime.utils.ConguParam());
				__CTOR_1_HAS_RUN = true;
				//RETURNS THIS
				BigNaturalPMonitoring.BigNatural(((BigNatural)__CTOR_1), false, true);
				__CTOR_1_HAS_RUN = true;
				boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__CTOR_0), ((BigNatural)__CTOR_1), false));
				if (!__CONGU_ASSERT_RESULT) {
					java.util.Map<String, String> __CONTEXT_VARIABLES_6 = new java.util.HashMap<String, String>(); {
						__CONTEXT_VARIABLES_6.put("i : int;*", a+"");
					}
					java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_6 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
						if (__CTOR_0_HAS_RUN)
							__CONTEXT_TERMS_6.add(new runtime.utils.ConguContextMethodCall("make(i)", __CTOR_0+""));
						if (__CTOR_1_HAS_RUN)
							__CONTEXT_TERMS_6.add(new runtime.utils.ConguContextMethodCall("zero()", __CTOR_1+""));
					}
					MethodContext __METHOD_CONTEXT_6 = new MethodContext(false, "make(i) = zero() when (i = 0) else suc(make((i - 1)));", __CONTEXT_VARIABLES_6, __CONTEXT_TERMS_6, "BigNatural");
					throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_6);
				}
			} else {
				//TARGET
				__CTOR_0 = ((BigNatural)thisObj);
				__CTOR_0_HAS_RUN = true;
				if (((Boolean)(((Integer)((Integer)((Integer)(((Integer)a) - 1)))) >= 0))) {
					//CONSTRUCTOR
					__CTOR_2 = new BigNatural(((Integer)((Integer)(((Integer)a) - 1))), new runtime.utils.ConguParam());
					__CTOR_2_HAS_RUN = true;
					//RETURNS THIS
					BigNaturalPMonitoring.BigNatural(((BigNatural)__CTOR_2), ((Integer)((Integer)(((Integer)a) - 1))), false, true);
					__CTOR_2_HAS_RUN = true;
					//RETURNS RESULT
					__VAR_3 = BigNaturalPMonitoring.suc(((BigNatural)__CTOR_2), false);
					__VAR_3_HAS_RUN = true;
					boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__CTOR_0), ((BigNatural)__VAR_3), false));
					if (!__CONGU_ASSERT_RESULT) {
						java.util.Map<String, String> __CONTEXT_VARIABLES_6 = new java.util.HashMap<String, String>(); {
							__CONTEXT_VARIABLES_6.put("i : int;*", a+"");
						}
						java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_6 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
							if (__CTOR_0_HAS_RUN)
								__CONTEXT_TERMS_6.add(new runtime.utils.ConguContextMethodCall("make(i)", __CTOR_0+""));
							if (__CTOR_2_HAS_RUN)
								__CONTEXT_TERMS_6.add(new runtime.utils.ConguContextMethodCall("make((i - 1))", __CTOR_2+""));
							if (__VAR_3_HAS_RUN)
								__CONTEXT_TERMS_6.add(new runtime.utils.ConguContextMethodCall("suc(make((i - 1)))", __VAR_3+""));
						}
						MethodContext __METHOD_CONTEXT_6 = new MethodContext(false, "make(i) = zero() when (i = 0) else suc(make((i - 1)));", __CONTEXT_VARIABLES_6, __CONTEXT_TERMS_6, "BigNatural");
						throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_6);
					}
				}
			}
		} catch (ConguException __ce) {
			throw __ce;
		} catch (Exception __e) {
		}
	}


	public static void addLast(BigNatural thisObj, int a, boolean isMonitoring, boolean executeMethod) {
		//PUTS
		if (isMonitoring) {
			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}

		//VARIABLE CLONING
		BigNatural thisObjOld = (BigNatural)clone(thisObj, false);
		int aOld = ((Integer)a);

		//RUN METHOD
		if (executeMethod)
			thisObj.addLast_CONGU(a);



		if (isMonitoring) {

			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}


	}

	public static BigNatural sum(BigNatural thisObj, BigNatural a, boolean isMonitoring) {
		if(a != null) {
		//PUTS
		if (isMonitoring) {
			_domain_BigNatural.put(a != null ? a : null);
			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}

		//VARIABLE CLONING
		BigNatural thisObjOld = (BigNatural)clone(thisObj, false);
		BigNatural aOld = ((BigNatural)a);

		//RUN METHOD
		BigNatural result = thisObj.sum_CONGU(a);



		if (isMonitoring) {

			_domain_BigNatural.put(result != null ? result : null);
		}


		return result;
		} else {
			return thisObj.sum_CONGU(a);
		}

	}

	public static BigNatural mult(BigNatural thisObj, BigNatural a, boolean isMonitoring) {
		if(a != null) {
		//PUTS
		if (isMonitoring) {
			_domain_BigNatural.put(a != null ? a : null);
			_domain_BigNatural.put(thisObj != null ? thisObj : null);
		}

		//VARIABLE CLONING
		BigNatural thisObjOld = (BigNatural)clone(thisObj, false);
		BigNatural aOld = ((BigNatural)a);

		//RUN METHOD
		BigNatural result = thisObj.mult_CONGU(a);



		if (isMonitoring) {

			_domain_BigNatural.put(result != null ? result : null);
		}


		return result;
		} else {
			return thisObj.mult_CONGU(a);
		}

	}

	@SuppressWarnings("unchecked")
	public static Object clone(Object thisObj, boolean isMonitoring) {
		Object thisClone = thisObj;
		
		if (isMonitoring && !(equals((BigNatural)thisObj, thisClone, false)))
			throw new runtime.exceptions.PostconditionException(new MethodContext(false, "CLONE/EQUALS", new java.util.HashMap<String, String>(), new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(), "BigNatural"));

		return thisClone;
	}

	public static boolean equals(BigNatural thisObj, Object other, boolean isMonitoring) {
		BigNatural thisOld = (BigNatural)clone(thisObj, false);
		
		boolean result = ((BigNatural)thisObj).equals_CONGU(other);

		if (isMonitoring)
			equals_POST_CONDITION(thisObj, thisOld, other, result);
	
		return result;
	}
	
	public static void equals_POST_CONDITION(BigNatural thisObj, BigNatural thisObjOld, Object other, boolean result) {
		//(I = J) if (suc(I) = suc(J));
		try {
			BigNatural __VAR_0 = null;
			boolean __VAR_0_HAS_RUN = false;
			BigNatural __VAR_1 = null;
			boolean __VAR_1_HAS_RUN = false;
			//RETURNS RESULT
			__VAR_0 = BigNaturalPMonitoring.suc(((BigNatural)thisObjOld), false);
			__VAR_0_HAS_RUN = true;
			//RETURNS RESULT
			__VAR_1 = BigNaturalPMonitoring.suc(((BigNatural)other), false);
			__VAR_1_HAS_RUN = true;
			boolean __COND_RESULT_2 = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)__VAR_0), ((BigNatural)__VAR_1), false));
			if (__COND_RESULT_2) {
				boolean __CONGU_ASSERT_RESULT = ((Boolean)BigNaturalPMonitoring.equals(((BigNatural)thisObjOld), ((Object)other), false));
				if (!__CONGU_ASSERT_RESULT) {
					java.util.Map<String, String> __CONTEXT_VARIABLES_7 = new java.util.HashMap<String, String>(); {
						__CONTEXT_VARIABLES_7.put("I : Natural;*", thisObjOld+"");
						__CONTEXT_VARIABLES_7.put("J : Natural;*", other+"");
					}
					java.util.List<runtime.utils.ConguContextMethodCall> __CONTEXT_TERMS_7 = new java.util.ArrayList<runtime.utils.ConguContextMethodCall>(); {
						if (__VAR_0_HAS_RUN)
							__CONTEXT_TERMS_7.add(new runtime.utils.ConguContextMethodCall("suc(I)", __VAR_0+""));
						if (__VAR_1_HAS_RUN)
							__CONTEXT_TERMS_7.add(new runtime.utils.ConguContextMethodCall("suc(J)", __VAR_1+""));
					}
					MethodContext __METHOD_CONTEXT_7 = new MethodContext(false, "(I = J) if (suc(I) = suc(J));", __CONTEXT_VARIABLES_7, __CONTEXT_TERMS_7, "BigNatural");
					throw new runtime.exceptions.PostconditionException(__METHOD_CONTEXT_7);
				}
			}
		} catch (ConguException __ce) {
			throw __ce;
		} catch (Exception __e) {
		}

	}

}