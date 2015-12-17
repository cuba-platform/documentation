package com.company.demo.gui.contract;

import com.haulmont.bpm.entity.ProcDefinition;
import com.haulmont.bpm.entity.ProcInstance;
import com.haulmont.bpm.gui.action.ProcAction;
import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.app.core.file.FileDownloadHelper;
import com.haulmont.cuba.gui.components.*;
import com.company.demo.entity.Contract;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.data.DsContext;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Map;

public class ContractEdit extends AbstractEditor<Contract> {

    private static final String PROCESS_CODE = "contractApproval";

    @Inject
    private DataManager dataManager;

    private ProcDefinition procDefinition;

    private ProcInstance procInstance;

    @Inject
    private ProcActionsFrame procActionsFrame;

    @Inject
    private GroupBoxLayout procActionsBox;

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private Table attachmentsTable;

    @Inject
    private Metadata metadata;

    @Override
    protected void postInit() {
        super.postInit();
        procDefinition = findProcDefinition();
        if (procDefinition != null) {
            procInstance = findProcInstance();
            if (procInstance == null) {
                procInstance = metadata.create(ProcInstance.class);
                procInstance.setProcDefinition(procDefinition);
                procInstance.setEntityName("demo$Contract");
                procInstance.setEntityId(getItem().getId());
            }
            initProcActionsFrame();
        }
        getDsContext().addListener(new DsContext.CommitListenerAdapter() {
            @Override
            public void beforeCommit(CommitContext context) {
                if (procInstance != null && PersistenceHelper.isNew(procInstance)) {
                    context.getCommitInstances().add(procInstance);
                }
            }
        });
        FileDownloadHelper.initGeneratedColumn(attachmentsTable, "file");
    }

    private void initProcActionsFrame() {
        procActionsFrame.setBeforeStartProcessPredicate(new ProcAction.BeforeActionPredicate() {
            @Override
            public boolean evaluate() {
                if (PersistenceHelper.isNew(getItem())) {
                    showNotification(getMessage("saveContract"), NotificationType.WARNING);
                    return false;
                }
                return true;
            }
        });
        procActionsFrame.setAfterStartProcessListener(new ProcAction.AfterActionListener() {
            @Override
            public void actionCompleted() {
                showNotification(getMessage("processStarted"), NotificationType.HUMANIZED);
                close(COMMIT_ACTION_ID);
            }
        });
        procActionsFrame.setBeforeCompleteTaskPredicate(new ProcAction.BeforeActionPredicate() {
            @Override
            public boolean evaluate() {
                return commit();
            }
        });
        procActionsFrame.setAfterCompleteTaskListener(new ProcAction.AfterActionListener() {
            @Override
            public void actionCompleted() {
                showNotification(getMessage("taskCompleted"), NotificationType.HUMANIZED);
                close(COMMIT_ACTION_ID);
            }
        });
        procActionsFrame.setCancelProcessEnabled(false);
        procActionsFrame.init(procInstance);
    }


    @Nullable
    private ProcDefinition findProcDefinition() {
        LoadContext ctx = new LoadContext(ProcDefinition.class);
        ctx.setQueryString("select pd from bpm$ProcDefinition pd where pd.code = :code")
                .setParameter("code", PROCESS_CODE);
        return (ProcDefinition) dataManager.load(ctx);
    }

    @Nullable
    private ProcInstance findProcInstance() {
        LoadContext ctx = new LoadContext(ProcInstance.class).setView("procInstance-start");
        ctx.setQueryString("select pi from bpm$ProcInstance pi where pi.procDefinition.id = :procDefinition and pi.entityId = :entityId")
                .setParameter("procDefinition", procDefinition)
                .setParameter("entityId", getItem());
        return (ProcDefinition) dataManager.load(ctx);
    }
}