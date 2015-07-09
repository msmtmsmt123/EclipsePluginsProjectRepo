package com.odcgroup.process.translation.command;

import java.util.Locale;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.odcgroup.translation.core.ITranslation;
import com.odcgroup.translation.core.ITranslationKind;
import com.odcgroup.translation.ui.command.EMFDeleteTranslationCommand;
import com.odcgroup.translation.ui.views.ITranslationModel;

/**
 * @author atr
 */
public class ProcessRemoveTranslationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IEvaluationContext ctx = (IEvaluationContext) event.getApplicationContext();

		// Get the translation model
		ITranslationModel model = (ITranslationModel) ctx.getVariable("model");

		// Get the CommandStack
		CommandStack cs = (CommandStack) ctx.getVariable("commandStack");

		// Get the editing domain
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)ctx.getVariable("editingDomain");

		ITranslationKind kind = model.getSelectedKind();
		Locale locale = model.getSelectedLocale();
		ITranslation translation = model.getTranslation();

		final EMFDeleteTranslationCommand cmd = new EMFDeleteTranslationCommand(translation, kind, locale);
		RecordingCommand transactionalCommand = new RecordingCommand((TransactionalEditingDomain)editingDomain) {
			@Override
			protected void doExecute() {
				cmd.execute();
			}
		};
		
		cs.execute(transactionalCommand);


		return null;
	}

}
