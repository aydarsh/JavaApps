class QuadraticEquation {
	public static void main(String[] args) {
		double a, b, c, discriminant, x1, x2;
		a = 1;
		b = 1;
		c = -2;
		discriminant = b*b-4*a*c;
		x1=(-b+Math.sqrt(discriminant))/(2*a);
		x2=(-b-Math.sqrt(discriminant))/(2*a);
		System.out.format("%.1fx*x+%.1fx+%.1f=0%n", a, b, c);
		System.out.format("Discriminant = %.1f%n", discriminant);
		System.out.format("x1=%.1f, x2=%.1f%n", x1, x2);
	}
}