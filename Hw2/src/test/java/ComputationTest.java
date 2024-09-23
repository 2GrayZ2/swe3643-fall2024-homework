import org.example.Computation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class ComputationTest {

    @Test
    @DisplayName("Test Compute Mean Valid Input")
    void computeMean_ValidInput_ReturnsCorrectMean() {
        // Arrange
        double[] values = {1, 2, 3, 4, 5};

        // Act
        double mean = Computation.computeMean(values);

        // Assert
        assertEquals(3.0, mean, 0.0001);  // Expected mean is 3.0
    }

    @Test
    @DisplayName("Test Compute Mean Empty Array")
    void computeMean_EmptyArray_ThrowsIllegalArgumentException() {
        // Arrange
        double[] values = {};

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Computation.computeMean(values);
        });

        // Assert
        assertEquals("valuesList parameter cannot be null or empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test Compute Mean Null Array")
    void computeMean_NullArray_ThrowsIllegalArgumentException(){
        // Arrange
        double[] values = null;

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Computation.computeMean(values);
        });

        // Assert
        assertEquals("valuesList parameter cannot be null or empty", exception.getMessage());
    }


    @Test
    @DisplayName("Test Compute Sample Standard Deviation Valid Input")
    void computeSampleStandardDeviation_ValidInput_ReturnsCorrectSampleStdDev() {
        // Arrange
        double [] values = {9, 6, 8, 5, 7};

        // Act
        double sampleStdDev = Computation.computeSampleStandardDeviation(values);

        // Assert
        assertEquals(1.5811388300841898, sampleStdDev);  // Expected sample std deviation
    }

    @Test
    @DisplayName("Test Compute Sample Standard Deviation Valid Input")
    void computePopulationStandardDeviation_ValidInput_ReturnsCorrectPopulationStdDev() {
        // Arrange
        double[] values = {9, 2, 5, 4, 12, 7, 8, 11, 9, 3, 7, 4, 12, 5, 4, 10, 9, 6, 9, 4};

        // Act
        double popStdDev = Computation.computePopulationStandardDeviation(values);

        // Assert
        assertEquals(2.9833, popStdDev, 0.0001);  // Expected population std deviation
    }

    @Test
    @DisplayName("Test Compute Sample Standard Deviation Valid Input")
    void computeVariance_InvalidSampleSize_ThrowsIllegalArgumentException(){
        // Arrange
        double squareOfDifferences = 10.0;
        int numValues = 1;  // Invalid sample size

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Computation.computeVariance(squareOfDifferences, numValues, false);
        });

        // Assert
        assertEquals("numValues is too low (sample size must be >= 2, population size must be >= 1)", exception.getMessage());
    }


    @Test
    @DisplayName("Test Interpret Standard Deviation")
    void standard_deviation_receive_stddev_value_return_label(double stdDev, String expectedLabel){
        //Act
        String actualLabel = Computation.interpretStandardDeviation(stdDev);

        //Assert
        assertEquals(actualLabel,expectedLabel);

    }



}
