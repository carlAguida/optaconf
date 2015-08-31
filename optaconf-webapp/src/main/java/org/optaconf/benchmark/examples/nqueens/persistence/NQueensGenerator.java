package org.optaconf.benchmark.examples.nqueens.persistence;


import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.optaconf.benchmark.examples.common.app.LoggingMain;
import org.optaconf.benchmark.examples.common.persistence.AbstractSolutionImporter;
import org.optaconf.benchmark.examples.common.persistence.SolutionDao;
import org.optaconf.benchmark.examples.nqueens.domain.Column;
import org.optaconf.benchmark.examples.nqueens.domain.NQueens;
import org.optaconf.benchmark.examples.nqueens.domain.Queen;
import org.optaconf.benchmark.examples.nqueens.domain.Row;

public class NQueensGenerator extends LoggingMain {

    private static final File outputDir = new File("data/nqueens/unsolved/");

    protected SolutionDao solutionDao;

    public static void main(String[] args) {
        new NQueensGenerator().generate();
    }

    public void generate() {
        solutionDao = new NQueensDao();
        writeNQueens(4);
//        writeNQueens(5);
//        writeNQueens(6);
//        writeNQueens(7);
        writeNQueens(8);
//        writeNQueens(9);
//        writeNQueens(10);
//        writeNQueens(11);
//        writeNQueens(12);
//        writeNQueens(13);
//        writeNQueens(14);
//        writeNQueens(15);
        writeNQueens(16);
//        writeNQueens(17);
//        writeNQueens(18);
//        writeNQueens(19);
//        writeNQueens(20);
//        writeNQueens(21);
//        writeNQueens(22);
//        writeNQueens(23);
//        writeNQueens(24);
//        writeNQueens(25);
//        writeNQueens(26);
//        writeNQueens(27);
//        writeNQueens(28);
//        writeNQueens(29);
//        writeNQueens(30);
//        writeNQueens(31);
        writeNQueens(32);
        writeNQueens(64);
        writeNQueens(256);
//        writeNQueens(10000);
//        writeNQueens(100000);
//        writeNQueens(1000000);
    }

    private void writeNQueens(int n) {
        String outputFileName = n + "queens.xml";
        File outputFile = new File(outputDir, outputFileName);
        NQueens nQueens = createNQueens(n);
        solutionDao.writeSolution(nQueens, outputFile);
    }

    public NQueens createNQueens(int n) {
        NQueens nQueens = new NQueens();
        nQueens.setId("0");
        nQueens.setN(n);
        nQueens.setColumnList(createColumnList(nQueens));
        nQueens.setRowList(createRowList(nQueens));
        nQueens.setQueenList(createQueenList(nQueens));
        BigInteger possibleSolutionSize = BigInteger.valueOf(nQueens.getN()).pow(nQueens.getN());
        logger.info("NQueens {} has {} queens with a search space of {}.",
                n, nQueens.getN(),
                AbstractSolutionImporter.getFlooredPossibleSolutionSize(possibleSolutionSize));
        return nQueens;
    }

    private List<Column> createColumnList(NQueens nQueens) {
        int n = nQueens.getN();
        List<Column> columnList = new ArrayList<Column>(n);
        for (int i = 0; i < n; i++) {
            Column column = new Column();
            column.setId(String.valueOf((long) i));
            column.setIndex(i);
            columnList.add(column);
        }
        return columnList;
    }

    private List<Row> createRowList(NQueens nQueens) {
        int n = nQueens.getN();
        List<Row> rowList = new ArrayList<Row>(n);
        for (int i = 0; i < n; i++) {
            Row row = new Row();
            row.setId(String.valueOf((long) i));
            row.setIndex(i);
            rowList.add(row);
        }
        return rowList;
    }

    private List<Queen> createQueenList(NQueens nQueens) {
        int n = nQueens.getN();
        List<Queen> queenList = new ArrayList<Queen>(n);
        long id = 0;
        for (Column column : nQueens.getColumnList()) {
            Queen queen = new Queen();
            queen.setId(String.valueOf(id));
            id++;
            queen.setColumn(column);
            // Notice that we leave the PlanningVariable properties on null
            queenList.add(queen);
        }
        return queenList;
    }

}
