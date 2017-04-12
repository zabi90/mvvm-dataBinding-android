package io.devcrew.mvvmdatabinding.viewModel;

import android.content.Intent;

/**
 * Created by zohaib on 12/04/2017.
 */

public interface IViewModel {
    void onResume();
    void onPause();
    void onDestroy();
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
