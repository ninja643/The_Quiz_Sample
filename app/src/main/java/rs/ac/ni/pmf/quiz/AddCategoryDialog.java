package rs.ac.ni.pmf.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class AddCategoryDialog extends DialogFragment {
    public interface AddCategoryDialogListener {
        void onAddCategory(String category);
    }

    private AddCategoryDialogListener addCategoryDialogListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        addCategoryDialogListener = (AddCategoryDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final EditText input = new EditText(getActivity());
        input.setInputType(InputType.TYPE_CLASS_TEXT);

        return builder
                .setTitle(R.string.add_new_category)
                .setView(input)
                .setPositiveButton(
                        R.string.ok,
                        (dialog, which) -> addCategoryDialogListener.onAddCategory(input.getText().toString()))
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel())
                .create();
    }
}
