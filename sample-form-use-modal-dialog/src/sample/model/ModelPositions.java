package sample.model;

/**
 *
 * @author RAVEN
 */
public class ModelPositions {

    public int getPositionsId() {
        return positionsId;
    }

    public void setPositionsId(int positionsId) {
        this.positionsId = positionsId;
    }

    public String getPositionsName() {
        return positionsName;
    }

    public void setPositionsName(String positionsName) {
        this.positionsName = positionsName;
    }

    public ModelPositions(int positionsId, String positionsName) {
        this.positionsId = positionsId;
        this.positionsName = positionsName;
    }

    public ModelPositions() {
    }

    private int positionsId;
    private String positionsName;

    @Override
    public String toString() {
        return positionsName;
    }
}
