package ru.toxyxd.template.uikit.page

import androidx.compose.runtime.Composable
import ru.toxyxd.template.uikit.vm.PageViewModel

@Composable
fun <T> PageLayout(
    state: PageViewModel.State<T>,
    onReload: () -> Unit,
    successContent: @Composable (data: T) -> Unit
) {
    when (state) {
        is PageViewModel.State.Loading -> FullscreenLoading()
        is PageViewModel.State.Error -> FullscreenError(onReload = onReload, exception = state.exception)
        is PageViewModel.State.Loaded -> successContent(state.data)
    }
}