package com.astcode.parser.controller;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileVisitor;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.DocumentUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author bresai
 */
public class PsiGenerator extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }

        VirtualFile rootDir = project.getBaseDir();

        VfsUtil.visitChildrenRecursively(rootDir, new VirtualFileVisitor() {
            @Override
            public boolean visitFile(@NotNull VirtualFile file) {
                PsiFileFactory.getInstance(project).
                VirtualFileManager.getInstance()
                System.out.println(file.get);
                return true;
            }
        });
    }

    private void processDir(VirtualFile file){
        if (file.isDirectory()){
            for (VirtualFile tmp : file.getChildren()){
                processDir(tmp);
            }
        }
    }
}
