package biometricauth.models;

/**
 *
 * @author Max
 */
public class HandGeometry {
    private String indexFingerHeight;
    private String middleFingerHeight;
    private String ringFingerHeight;
    private String pinkyHeight;
    private String palmHeight;
    private String palmAcrossLength;

    public HandGeometry() {
        String username;
    }

    public HandGeometry(String indexFingerHeight, String middleFingerHeight, String ringFingerHeight, String pinkyHeight, String palmHeight, String palmAcrossLength) {
        this.indexFingerHeight = indexFingerHeight;
        this.middleFingerHeight = middleFingerHeight;
        this.ringFingerHeight = ringFingerHeight;
        this.pinkyHeight = pinkyHeight;
        this.palmHeight = palmHeight;
        this.palmAcrossLength = palmAcrossLength;
    }

    public String getIndexFingerHeight() {
        return indexFingerHeight;
    }

    public void setIndexFingerHeight(String indexFingerHeight) {
        this.indexFingerHeight = indexFingerHeight;
    }

    public String getMiddleFingerHeight() {
        return middleFingerHeight;
    }

    public void setMiddleFingerHeight(String middleFingerHeight) {
        this.middleFingerHeight = middleFingerHeight;
    }

    public String getRingFingerHeight() {
        return ringFingerHeight;
    }

    public void setRingFingerHeight(String ringFingerHeight) {
        this.ringFingerHeight = ringFingerHeight;
    }

    public String getPinkyHeight() {
        return pinkyHeight;
    }

    public void setPinkyHeight(String pinkyHeight) {
        this.pinkyHeight = pinkyHeight;
    }

    public String getPalmHeight() {
        return palmHeight;
    }

    public void setPalmHeight(String palmHeight) {
        this.palmHeight = palmHeight;
    }

    public String getPalmAcrossLength() {
        return palmAcrossLength;
    }

    public void setPalmAcrossLength(String palmAcrossLength) {
        this.palmAcrossLength = palmAcrossLength;
    }
    @Override
    public String toString() {
        return "HandGeometry{" +
                "indexFingerHeight='" + indexFingerHeight + '\'' +
                ", middleFingerHeight='" + middleFingerHeight + '\'' +
                ", ringFingerHeight='" + ringFingerHeight + '\'' +
                ", pinkyHeight='" + pinkyHeight + '\'' +
                ", palmHeight='" + palmHeight + '\'' +
                ", palmAcrossLength='" + palmAcrossLength + '\'' +
                '}';
    }

}
