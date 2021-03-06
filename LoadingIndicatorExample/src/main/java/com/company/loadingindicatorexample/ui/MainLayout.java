
package com.company.loadingindicatorexample.ui;

import java.util.stream.IntStream;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.LoadingIndicatorConfiguration;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.InitialPageSettings;
import com.vaadin.flow.server.PageConfigurator;


@Route("")
@HtmlImport("frontend://styles/shared-styles.html")
public class MainLayout extends VerticalLayout implements PageConfigurator
{
	public MainLayout()
	{
		super();
		this.initUI();
	}

	@Override
	public void configurePage(final InitialPageSettings settings)
	{
		settings.addLink("shortcut icon", "frontend/images/favicon.ico");
		settings.addFavIcon("icon", "frontend/images/favicon256.png", "256x256");
		
		final LoadingIndicatorConfiguration li = settings.getLoadingIndicatorConfiguration();
		li.setApplyDefaultTheme(true);
		li.setFirstDelay(300);
	}

	/**
	 * Event handler delegate method for the {@link Button} {@link #button}.
	 *
	 * @see ComponentEventListener#onComponentEvent(ComponentEvent)
	 * @eventHandlerDelegate Do NOT delete, used by UI designer!
	 */
	private void button_onClick(final ClickEvent<Button> event)
	{
		IntStream.range(1, 10).forEach(i -> {
			try
			{
				Thread.sleep(500);
			}
			catch(final InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	/* WARNING: Do NOT edit!<br>The content of this method is always regenerated by the UI designer. */
	// <generated-code name="initUI">
	private void initUI()
	{
		this.button = new Button();

		this.button.setText("Do something");

		this.button.setSizeUndefined();
		this.add(this.button);
		this.setSizeFull();

		this.button.addClickListener(this::button_onClick);
	} // </generated-code>
	
	// <generated-code name="variables">
	private Button button;
	// </generated-code>

}
