package generic;

public class DataSetGen<T extends Measurable> {
    private double sum;
    private T maximum;
    private int count;

    public DataSetGen() {
        sum = 0;
        count = 0;
        maximum = null;
    }

    /**
     * Adds a data value to the data set.
     * @param x a data value that implements Measurable
     */
    public void add(T x) {
        sum += x.getMeasure(); // Using the getMeasure method from Measurable
        if (count == 0 || (maximum != null && maximum.getMeasure() < x.getMeasure())) {
            maximum = x; // Update maximum if necessary
        }
        count++;
    }

    /**
     * Gets the average of the added data.
     * @return the average or 0 if no data has been added
     */
    public double getAverage() {
        return (count == 0) ? 0 : sum / count;
    }

    /**
     * Gets the largest of the added data.
     * @return the maximum or null if no data has been added
     */
    public T getMaximum() {
        return maximum;
    }
}