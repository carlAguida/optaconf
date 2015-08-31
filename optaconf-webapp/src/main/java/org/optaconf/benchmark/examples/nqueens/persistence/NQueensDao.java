package org.optaconf.benchmark.examples.nqueens.persistence;

import org.optaconf.benchmark.examples.common.persistence.XStreamSolutionDao;
import org.optaconf.benchmark.examples.nqueens.domain.NQueens;

public class NQueensDao extends XStreamSolutionDao {

    public NQueensDao() {
        super("nqueens", NQueens.class);
    }

}
