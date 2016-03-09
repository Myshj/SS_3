/**
 * Created by alexey on 08.03.16.
 */

/**
 * Represents parabola (y = a * x * x + b * x + c).
 */
public class Parabola extends Function implements Cloneable, BackwardCalculable {

    /**
     * Multiplier near x * x.
     */
    private double a;
    /**
     * Multiplier near x.
     */
    private double b;
    /**
     * Free member.
     */
    private double c;

    public Parabola() {
        a = 0.0;

        b = 0.0;

        c = 0.0;
    }

    public Parabola(final double a,
                    final double b,
                    final double c) {
        this.a = a;

        this.b = b;

        this.c = c;
    }

    public Parabola(final Parabola other) {
        a = other.a;

        b = other.b;

        c = other.c;
    }

    @Override
    public String toString() {
        return "Parabola{\na: " + a + ",\n" +
                "b: " + b + ",\n" +
                "c: " + c + "\n}";
    }

    @Override
    public int hashCode() {
        int prime = 23;

        int hash = 1;

        hash = hash * prime + new Double(a).hashCode();

        hash = hash * prime + new Double(b).hashCode();

        hash = hash * prime + new Double(c).hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if ((null == obj) || (getClass() != obj.getClass())) {
            return false;
        }

        Parabola other = (Parabola) obj;

        return a == other.a &&
                b == other.b &&
                c == other.c;
    }

    public Parabola clone() throws CloneNotSupportedException {
        Parabola newParabola = (Parabola) super.clone();

        newParabola.a = a;
        newParabola.b = b;
        newParabola.c = c;

        return newParabola;
    }

    /**
     * Calculates parabola.
     *
     * @param x Argument for function.
     * @return a * x * x + b * x + c.
     */
    public double calculate(double x) {
        return a * x * x + b * x + c;
    }

    /**
     * Returns array of possible arguments that satisfy condition a * x * x + b * x + c = y.
     * Returns:
     * Empty array if a==0 AND b==0;
     * {-(y-c)/a, (y-c)/a} if a!=0 AND b==0;
     * {(y-c)/b} if a==0 AND b!=0;
     * {(-b-Math.sqrt(b*b-4*a*(c-y)))/(2*a), (-b+Math.sqrt(b*b-4*a*(c-y)))/(2*a)}.
     *
     * @param y Value of function.
     * @return Array of possible arguments.
     */
    public double[] doBackwardCalculation(final double y) {

        if (0 == a) {
            return 0 == b ? new double[0] : new double[]{(y - c) / b};
        }

        if (0 == b) {
            return new double[]{-Math.sqrt((y - c) / a), Math.sqrt((y - c) / a)};
        }

        double tempC = c - y;

        double discriminant = Math.sqrt(b * b - 4 * a * tempC);

        double x1 = (-b - discriminant) / (2 * a);
        double x2 = (-b + discriminant) / (2 * a);

        return new double[]{x1, x2};
    }

    /**
     * Returns a.
     *
     * @return Value of a.
     */
    public double getA() {
        return a;
    }

    /**
     * Sets new value for a.
     *
     * @param a New value for a.
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Returns b.
     *
     * @return Value of b.
     */
    public double getB() {
        return b;
    }

    /**
     * Sets new value for b.
     *
     * @param b New value for b.
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Returns c.
     *
     * @return Value of c.
     */
    public double getC() {
        return c;
    }

    /**
     * Sets new value for c.
     *
     * @param c New value for c.
     */
    public void setC(double c) {
        this.c = c;
    }
}
