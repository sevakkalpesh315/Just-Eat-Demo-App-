package myapp.tae.ac.uk.justeattest.Presenters;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import myapp.tae.ac.uk.justeattest.Interfaces.DataServiceInterface;
import myapp.tae.ac.uk.justeattest.Interfaces.JustEatView;
import myapp.tae.ac.uk.justeattest.R;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Kalpesh on 20/06/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class JustEatPresenterTest {
    @Mock
    private JustEatView view;
    @Mock
    private DataServiceInterface dataService;
    private JustEatPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new JustEatPresenter(view);
        dataService.addObserverInObservable(presenter);
    }

    @Test
    public void testDisplayWhenSearchIsInvalid() throws Exception {
        when(view.getSearchText()).thenReturn("");
        presenter.onSearchButtonClicked();
        verify(view).showEmptyPostCodeError(R.string.error_search_empty);
        
        when(view.getSearchText()).thenReturn("12345");
        presenter.onSearchButtonClicked();
        verify(view).showPostCodeFormatError(R.string.error_search_format);
    }

    @Test
    public void testFetchDataNotEmptyAndRestaurantActivityStartOnCorrectPostCode() throws Exception {
        when(view.getSearchText()).thenReturn("E6 2JX");
        presenter.onSearchButtonClicked();
        verify(view).filterOrDisplayLastUpdatedData();
    }
}