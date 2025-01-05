<%@page import="com.wedding.planner.config.general.Configurations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>

<title>Terms Of Service | <%=Configurations.NAME%></title>

<jsp:include page="components/head-imports.jsp" />
</head>
<body class="d-flex flex-column">
    <div class="page page-center">
        <div class="container container-narrow py-4">
            <div class="text-center mb-4">
                <a href="." class="navbar-brand navbar-brand-autodark">
                    <img src="./static/logo.svg" width="110" height="32" alt="Wedding Planner" class="navbar-brand-image">
                </a>
            </div>
            <div class="card card-md">
                <div class="card-body">
                    <h3 class="card-title">Terms of Service</h3>
                    <div class="markdown">
                        <p>Welcome to the Terms of Service for our Wedding Planning Platform. Our platform acts as an intermediary between vendors and users, facilitating the placement and consumption of services.</p>
                        <hr />
                        <p>By using our platform, you agree to abide by these terms of service. Please read them carefully before accessing or using any part of our services. If you do not agree to these terms, you may not access or use our platform.</p>
                        <h3 id="1-wedding-planning-platform">1. Wedding Planning Platform</h3>
                        <ul>
                            <li>
                                <p><strong>Responsibility of Users and Vendors:</strong> Users and vendors are responsible for the content they post and any harm resulting from that content or conduct. Ensure that your content complies with our guidelines and legal requirements.</p>
                            </li>
                            <li>
                                <p><strong>HTTPS:</strong> We prioritize security and offer free HTTPS on all accounts by default.</p>
                            </li>
                        </ul>
                        <h3 id="2-responsibility-of-users">2. Responsibility of Users and Vendors</h3>
                        <p>Users and vendors using our platform must adhere to our community guidelines, legal requirements, and terms of service. We do not endorse or guarantee the accuracy of user-generated content and encourage reporting of any violations.</p>
                        <h3 id="3-copyright-and-intellectual-property">3. Copyright and Intellectual Property</h3>
                        <p>We respect intellectual property rights and require users and vendors to do the same. If you believe your copyright has been violated, please follow our DMCA policy for resolution.</p>
                        <h3 id="4-changes-to-terms">4. Changes to Terms</h3>
                        <p>We reserve the right to update these terms of service as needed. Users and vendors will be notified of any material changes, and continued use of the platform implies acceptance of the updated terms.</p>
                        <h3 id="5-disclaimer-of-warranties">5. Disclaimer of Warranties</h3>
                        <p>Our platform is provided "as is," and we disclaim any warranties regarding its accuracy, reliability, or suitability for a particular purpose. Users and vendors use the platform at their own risk.</p>
                        <h3 id="6-license">6. License</h3>
                        <p>By using our Wedding Planning Platform, you agree to comply with our licensing terms. Please review our license for more information.</p>
                        <h3 id="7-general-representation-and-warranty">7. General Representation and Warranty</h3>
                        <p>Users and vendors represent and warrant that their use of our platform complies with all applicable laws and regulations and does not infringe on the rights of others.</p>
                        <h3 id="8-refund-policy">8. Refund Policy</h3>
                        <p>Payments made for services on our platform are non-refundable unless explicitly stated otherwise by the vendor.</p>
                        <h3 id="9-translation">9. Translation</h3>
                        <p>These Terms of Service are originally written in English. Translations into other languages are provided for convenience, but the English version will prevail in case of any discrepancies.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="components/footer-imports.jsp" />
</body>
</html>
