package com.tsystems.javaschool.tasks.pyramid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < 253; i++) {
            input.add(i);
        }

        PyramidBuilder pyramidBuilder = new PyramidBuilder();
        int[][] out = pyramidBuilder.buildPyramid(input);

        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[i].length; j++) {
                System.out.print(out[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] buildPyramid(List<Integer> inputNumbers) {

        int aim = 0,
            layer = 1,
            size = inputNumbers.size();

        try{
            Collections.sort(inputNumbers);
        }catch (NullPointerException e){
            throw new CannotBuildPyramidException();
        }catch (OutOfMemoryError e){
            throw new CannotBuildPyramidException();
        }

        for (int i = 1; aim < size ; i++) {
            aim = aim + i;
            layer = i;
        }

        if (aim != size){
            throw new CannotBuildPyramidException();
        }

        int star = 0, space = 0, count = 0;

        int [][] out = new int[layer][2*layer-1];

        for (int ActualLine = 1; ActualLine <= layer; ActualLine ++)
        {
            int link = 0;
            space = layer - ActualLine;
            for(int i = 0; i < space; i++) {
                out[ActualLine-1][link] = 0;
                link++;
            }
            star = ActualLine * 2 - 1;
            for(int i = 0; i < star; i++) {
                if (i%2 == 0){
                    out[ActualLine-1][link] = inputNumbers.get(count);
                    link++;
                    count++;
                }else{
                    out[ActualLine-1][link] = 0;
                    link++;
                }
            }
            for(int i = 0; i < space; i++) {
                out[ActualLine-1][link] = 0;
                link++;
            }
        }
        return out;
    }
}
