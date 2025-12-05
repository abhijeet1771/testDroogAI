/**
 * Duplicate Code Test File
 * Contains duplicate code patterns for DroogAI to detect
 */
public class DuplicateCode {
    
    // DUPLICATE: Similar methods with 85%+ similarity
    public int calculateTotal(List<Integer> numbers) {
        int total = 0;
        for (Integer num : numbers) {
            total += num;
        }
        return total;
    }
    
    public int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    public double calculateAverage(List<Integer> numbers) {
        int total = 0;
        for (Integer num : numbers) {
            total += num;
        }
        return (double) total / numbers.size();
    }
    
    // DUPLICATE: Similar validation logic
    public boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (!email.contains("@")) {
            return false;
        }
        return true;
    }
    
    public boolean validatePhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        if (!phone.contains("-")) {
            return false;
        }
        return true;
    }
    
    // DUPLICATE: Similar error handling
    public void processFile1(String filename) {
        try {
            File file = new File(filename);
            // process file
        } catch (Exception e) {
            logger.error("Error processing file: " + filename);
            throw new RuntimeException(e);
        }
    }
    
    public void processFile2(String filename) {
        try {
            File file = new File(filename);
            // process file
        } catch (Exception e) {
            logger.error("Error processing file: " + filename);
            throw new RuntimeException(e);
        }
    }
}

