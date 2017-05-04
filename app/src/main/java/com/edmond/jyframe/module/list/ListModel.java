package com.edmond.jyframe.module.list;

import com.edmond.jyframe.classes.Student;
import com.edmond.jyframe.module.BaseModel;

/**
 * Created by edmond on 17-3-24.
 */

public class ListModel extends BaseModel<Student> implements ListModelInterface {
    @Override
    public void getList(ListPresenterInterface presenter) {
        presenter.returnList();
    }
}
