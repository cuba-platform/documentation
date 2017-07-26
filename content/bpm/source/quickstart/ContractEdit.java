package com.company.bpmdemo.web.contract;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.bpmdemo.entity.Contract;
import com.haulmont.bpm.entity.ProcAttachment;
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.Table;

import javax.inject.Inject;

public class ContractEdit extends AbstractEditor<Contract> {
    private static final String PROCESS_CODE = "contractApproval";

    @Inject
    private ProcActionsFrame procActionsFrame;

    @Inject
    private Table<ProcAttachment> attachmentsTable;

    @Override
    protected void postInit() {
        FileDownloadHelper.initGeneratedColumn(attachmentsTable, "file");
        initProcActionsFrame();
    }

    private void initProcActionsFrame() {
        procActionsFrame.initializer()
                .setBeforeStartProcessPredicate(this::commit)
                .setAfterStartProcessListener(() -> {
                    showNotification(getMessage("processStarted"), NotificationType.HUMANIZED);
                    close(COMMIT_ACTION_ID);
                })
                .setBeforeCompleteTaskPredicate(this::commit)
                .setAfterCompleteTaskListener(() -> {
                    showNotification(getMessage("taskCompleted"), NotificationType.HUMANIZED);
                    close(COMMIT_ACTION_ID);
                })
                .init(PROCESS_CODE, getItem());
    }
}