
// package org.apache.wicket.examples.authentication3;
package org.apache.wicket.examples.authentication1;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;

/**
 * A page only accessible by a user in the ADMIN role.
 * 
 * @author Jonathan Locke
 */
@AuthorizeInstantiation("ADMIN")
public class AdminPage extends BasePage
{
}