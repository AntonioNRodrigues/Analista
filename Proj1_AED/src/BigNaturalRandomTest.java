import java.util.Random;

/**
 * A class to randomly test BigNatural
 * 
 * @author antonialopes
 */
public class BigNaturalRandomTest {

	public static void main(String[] args) {
		new BigNaturalRandomTest(new BigNatural(123456789), 101011).run(); 
	}

	private final Random rand;

	private BigNatural num;

	private BigNatural prev;

	private final int howMany;

	private static final int MAX_OPERATIONS = 4;

	private static final int NUM_RESET = 10; // larger numbers will stress memory use

	public BigNaturalRandomTest(BigNatural num, int howMany) {
		this.num = num;
		this.prev = new BigNatural(Integer.MAX_VALUE);
		this.howMany = howMany;
		this.rand = new Random();
	}

	/**
	 * Call howMany operations on the BigNatural. Select randomly each operation to
	 * call. Check the preconditions of each call.
	 */
	public void run() {
		for (int i = 1; i < howMany; i++) {
			if (i%NUM_RESET == 0){
				System.out.println("zero");
				prev = num;
				num = new BigNatural();
			}
			else {
				switch (rand.nextInt(MAX_OPERATIONS)) {
				case 0:
					System.out.println("suc");
					prev = num;
					num = num.suc();
					break;
				case 1:
					int  k = rand.nextInt();
					if (k >= 0){
						System.out.println("make");
						prev = num; 
						num = new BigNatural(k);
					}
					break;
				case 2:
					System.out.println("sum");
					BigNatural aux = num; 
					num = num.sum(prev);
					prev = aux;
					break;
				case 3:
					System.out.println("mult");
					aux = num; 
					num = num.mult(prev);
					prev = aux;
					break;
				}
			}
			System.out.println(num);
		}
		System.out.println("done!");
	}
}
