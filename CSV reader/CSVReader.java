
import java.util.Arrays;

public class CSVReader extends ReadCSVFile {
    /**
     * data frame an String array that stores the
     * lines present in the file.
     */
    private String[] dataFrame;
    /**
     * This function is used to read the given csv File
     * This uses functions from the
     * ReadCSVFile class.
     *
     * @param fileName - name of the given csv file
     */
    public void readCSV(final String fileName) {
        dataFrame = ReadCSVFile.readFile(fileName);
    }
    /**
     * The number of rows in the given data frame.
     * Note: This shouldn't include
     * the coloumn labels.
     *
     * @return -1 if the Data set is empty
     */
    public int rowCount() {
        // TODO
        // Your code goes here....
        if (dataFrame.length != 0) {
           return dataFrame.length-1;
        } else {
            return -1;
        }
    }
    /**
     * This method returns the count of coloumns in a data Frame.
     * @return the count of columns in the dataset and -1 otherwise.
     */
    public int fieldCount() {
        // TODO
        // Your code goes here....
        if (dataFrame.length > 0) {
          return dataFrame[0].split(",").length;
    }
        return -1;
    }
    /**
     * This method returns the name of the column based on the index
     * passed as a parameter.
     *
     * @param index index of the coloumn starting from 1.
     * @return the column name based on the index and null otherwise.
     */
    public String getFieldName(final int index) {
        // TODO
        // Your code goes here....
        if(index > 0 && index < dataFrame.length) {
            for(int i = 0; i < dataFrame.length; i++) {
                if(i == index) {
                    return dataFrame[0].split(",")[index-1];
                }
            }
        }
    
        return null;
    }
    /**
     * This method returns the row (array of values)
     * based on the parameter
     * passed to the method.
     *
     * @param rowNumber given the Row of the row indexing
     * from 1. Exclude the column
     * header row.
     *
     * @return the string array containing the contents of the entire row.
     */
    public String[] getRow(final int rowNumber) {
        // TODO
        // Your code goes here....
        if(dataFrame.length == 0) {
            return null;
        }
        if (rowNumber > 0 && rowNumber < dataFrame.length) {
            String[] arr = dataFrame[rowNumber].split(",");
            return arr;
        }
      return null;
    }

    /**
     * This method returns the rows (String array) based on
     * fromIndex and toIndex.
     * The fromIndex and toIndex should be in the
     * range of the dataset lengths.
     *
     * @param fromIndex given from index
     * @param toIndex   given to index
     * @return String array containing the rows starting
     * from the fromindex to the toindex. Append the entire
     * row to the string array comma separated.
     */
    public String[] getRows(final int fromIndex, final int toIndex) {
        // TODO
        // Your code goes here....
        if(dataFrame.length == 0) {
            return null;
        }
        if (fromIndex == toIndex || toIndex<fromIndex) {
            return null;
        }
        String[] rows = new String[toIndex - fromIndex];
        int size = dataFrame.length-1;
        if (fromIndex < size  && toIndex < size
        && fromIndex >= 0 && toIndex >= 0) {
        int ind = 0;
        for (int index = fromIndex; index < toIndex; index++) {
            rows[ind] = dataFrame[index];
            ind++;

        }
        return rows;
    }
        return null;
    }
    /**
     * This method returns the column values based on particular column index.
     *
     * @param index index of the column
     * @return all the values of the column as a string array
     */
    public String[] getColumnValues(final int index) {
        // TODO
        // Your code goes here....
        // if(dataFrame.length == 0) {
        //     return null;
        // }
        if(index > 0 && index < dataFrame.length) {
            String[] arr = new String[dataFrame.length-1];
            int j=0;
            for (int i = 1; i < dataFrame.length; i++) {
                arr[j] = dataFrame[i].split(",")[index];
                j++;
            }
            return arr;
        }
        return null;
    }
}
    