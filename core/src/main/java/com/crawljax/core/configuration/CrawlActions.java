package com.crawljax.core.configuration;

import java.util.ArrayList;
import java.util.List;

import com.crawljax.condition.Condition;
import com.crawljax.core.state.Eventable.EventType;

/**
 * Specifies the actions for CrawlElements NOTE: In general CrawlActions is not designed to be
 * instantiated directly. CrawlActions should be used via {@link CrawlSpecification} To add
 * conditions to check whether a tag should (not) be clicked one can use {@link #when(Condition...)}
 * . See also {@link Condition}
 * 
 * @author DannyRoest@gmail.com (Danny Roest)
 * @version $Id$
 */
public class CrawlActions {

	private final List<CrawlElement> crawlElements = new ArrayList<CrawlElement>();
	private final List<CrawlElement> crawlElementsExcluded = new ArrayList<CrawlElement>();

	CrawlActions() {
	}

	/**
	 * Set of HTML elements Crawljax will click during crawling For exmple 1) <a.../> 2) <div/>
	 * click("a") will only include 1 if clickOnce is true (default). This set can be restricted by
	 * {@link #dontClick(String)}.
	 * 
	 * @param tagName
	 *            the tag name of the elements to be included
	 * @return this CrawlElement
	 */
	public CrawlElement click(String tagName) {
		CrawlElement crawlTag = new CrawlElement(EventType.click, tagName);
		crawlElements.add(crawlTag);
		return crawlTag;
	}

	/**
	 * Set of HTML elements Crawljax will NOT click during crawling When an HTML is present in the
	 * click and dontClick sets, then the element will not be clicked. For example: 1) <a
	 * href="#">Some text</a> 2) <a class="foo" .../> 3) <div class="foo" .../> click("a")
	 * dontClick("a").withAttribute("class", "foo"); Will include only include HTML element 2
	 * 
	 * @param tagName
	 *            the tag name of the elements to be excluded
	 * @return crawlTag the CrawlElement
	 */
	public CrawlElement dontClick(String tagName) {
		CrawlElement crawlTag = new CrawlElement(EventType.click, tagName);
		crawlElementsExcluded.add(crawlTag);
		return crawlTag;
	}

	/**
	 * @return the crawlElements
	 */
	protected List<CrawlElement> getCrawlElements() {
		return crawlElements;
	}

	/**
	 * @return the crawlElementsExcluded
	 */
	protected List<CrawlElement> getCrawlElementsExcluded() {
		return crawlElementsExcluded;
	}

}
