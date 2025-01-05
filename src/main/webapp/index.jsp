<!DOCTYPE html>
<html lang="en" data-bs-theme="light">
<head>
    <meta charset="utf-8">

    <!-- Viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, viewport-fit=cover">
    
      <!-- SEO meta tags for Wedding Planner -->
    <title>Wedding Planner | Make Your Wedding Memorable</title>
    <meta name="description" content="Plan and organize your dream wedding with our comprehensive wedding planner services. Budget management, guest list, vendor recommendations, and more.">
    <meta name="keywords" content="wedding planner, plan wedding, budget management, guest list, vendor recommendations, wedding services, wedding planning, wedding organization">
    <meta name="author" content="Smit Joshi">


    <!-- Webmanifest + Favicon / App icons -->
	<link rel="manifest" href="webmanifest.json" >
    <link rel="icon" type="image/png" href="assets/app-icons/icon-32x32.png" sizes="32x32">
    <link rel="apple-touch-icon" href="assets/app-icons/icon-180x180.png">
        
    <!-- Theme switcher (color modes) -->
    <script src="assets/js/theme-switcher.js"></script>

    <!-- Import Google font (Inter) -->
    <link rel="preconnect" href="https://fonts.googleapis.com/">
    <link rel="preconnect" href="https://fonts.gstatic.com/" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&amp;display=swap" rel="stylesheet" id="google-font">

    <!-- Vendor styles -->
    <link rel="stylesheet" media="screen" href="assets/vendor/swiper/swiper-bundle.min.css">
    <link rel="stylesheet" media="screen" href="assets/vendor/aos/dist/aos.css">

    <!-- Font icons -->
    <link rel="stylesheet" href="assets/icons/around-icons.min.css">

    <!-- Theme styles + Bootstrap -->
    <link rel="stylesheet" media="screen" href="assets/css/theme.min.css">

    <!-- CUstomization -->
    <style>
      :root{--ar-primary:#694949;--ar-primary-rgb:105,73,73;--ar-link-color:#694949;--ar-link-hover-color:#503030;}.btn-primary{--ar-btn-bg:#694949;--ar-btn-border-color:#694949;--ar-btn-hover-bg:#503030;--ar-btn-hover-border-color:#503030;--ar-btn-active-bg:#503030;--ar-btn-active-border-color:#503030;--ar-btn-disabled-bg:#694949;--ar-btn-disabled-border-color:#694949;}.btn-outline-primary{--ar-btn-color:#694949;--ar-btn-border-color:#694949;--ar-btn-hover-bg:#694949;--ar-btn-hover-border-color:#694949;--ar-btn-active-bg:#694949;--ar-btn-active-border-color:#694949;--ar-btn-disabled-color:#694949;--ar-btn-disabled-border-color:#694949;}.accordion-button:not(.collapsed)::after{--ar-accordion-btn-active-icon:url("data:image/svg+xml,%3csvg%20xmlns='http://www.w3.org/2000/svg'%20viewBox='0%200%2024%2024'%20fill='%23694949'%3e%3cpath%20d='M.5%206.3c.6-.6%201.6-.6%202.3%200l9.3%209.3%209.3-9.3c.6-.6%201.6-.6%202.3%200%20.6.6.6%201.6%200%202.3L13.3%2018.8c-.6.6-1.6.6-2.3%200L.8%208.5c-.9-.8-.9-1.6-.3-2.2z'/%3e%3c/svg%3e");}
    </style>

    <!-- Page loading styles -->
    <style>
      .page-loading {
        position: fixed;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 100%;
        -webkit-transition: all .4s .2s ease-in-out;
        transition: all .4s .2s ease-in-out;
        background-color: #fff;
        opacity: 0;
        visibility: hidden;
        z-index: 9999;
      }
      [data-bs-theme="dark"] .page-loading {
        background-color: #121519;
      }
      .page-loading.active {
        opacity: 1;
        visibility: visible;
      }
      .page-loading-inner {
        position: absolute;
        top: 50%;
        left: 0;
        width: 100%;
        text-align: center;
        -webkit-transform: translateY(-50%);
        transform: translateY(-50%);
        -webkit-transition: opacity .2s ease-in-out;
        transition: opacity .2s ease-in-out;
        opacity: 0;
      }
      .page-loading.active > .page-loading-inner {
        opacity: 1;
      }
      .page-loading-inner > span {
        display: block;
        font-family: "Inter", sans-serif;
        font-size: 1rem;
        font-weight: normal;
        color: #6f788b;
      }
      [data-bs-theme="dark"] .page-loading-inner > span {
        color: #fff;
        opacity: .6;
      }
      .page-spinner {
        display: inline-block;
        width: 2.75rem;
        height: 2.75rem;
        margin-bottom: .75rem;
        vertical-align: text-bottom;
        background-color: #d7dde2; 
        border-radius: 50%;
        opacity: 0;
        -webkit-animation: spinner .75s linear infinite;
        animation: spinner .75s linear infinite;
      }
      [data-bs-theme="dark"] .page-spinner {
        background-color: rgba(255,255,255,.25);
      }
      @-webkit-keyframes spinner {
        0% {
          -webkit-transform: scale(0);
          transform: scale(0);
        }
        50% {
          opacity: 1;
          -webkit-transform: none;
          transform: none;
        }
      }
      @keyframes spinner {
        0% {
          -webkit-transform: scale(0);
          transform: scale(0);
        }
        50% {
          opacity: 1;
          -webkit-transform: none;
          transform: none;
        }
      }
    </style>

    <!-- Page loading scripts -->
    <script>
      (function () {
        window.onload = function () {
          const preloader = document.querySelector('.page-loading')
          preloader.classList.remove('active')
          setTimeout(function () {
            preloader.remove()
          }, 1500)
        }
      })()
    </script>

  <!-- Body -->
  <body>

    <!-- Page loading spinner -->
    <div class="page-loading active">
      <div class="page-loading-inner">
        <div class="page-spinner"></div>
        <span>Loading...</span>
      </div>
    </div>


    <!-- Page wrapper -->
    <main class="page-wrapper">

      <!-- Navbar. Remove 'fixed-top' class to make the navigation bar scrollable with the page -->
      <header class="navbar navbar-expand-lg fixed-top">
        <div class="container">

          <!-- Navbar brand (Logo) -->
          <a class="navbar-brand pe-sm-3">
            <span class="text-primary flex-shrink-0 me-2">
              <img src="assets/app-icons/logo.png" width="150" alt="Wedding Planner" />
            </span>
          </a>

          <!-- Theme switcher -->
          <div class="form-check form-switch mode-switch order-lg-2 me-3 me-lg-4 ms-auto" data-bs-toggle="mode">
            <input class="form-check-input" type="checkbox" id="theme-mode">
            <label class="form-check-label" for="theme-mode">
              <i class="ai-sun fs-lg"></i>
            </label>
            <label class="form-check-label" for="theme-mode">
              <i class="ai-moon fs-lg"></i>
            </label>
          </div>

          <a class="text-primary btn btn-sm fs-sm order-lg-3 d-none d-sm-inline-flex me-2" href="/sign-in">
            <i class="ai-login fs-xl me-2 ms-n1"></i>
            login
          </a>

          <a class="btn btn-outline-primary btn-sm fs-sm order-lg-3 d-none d-sm-inline-flex" href="/sign-up">
            <i class="ai-user-group fs-xl me-2 ms-n1"></i>
            Became A Vendor
          </a>

          <!-- Mobile menu toggler (Hamburger) -->
          <button class="navbar-toggler ms-sm-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <!-- Navbar collapse (Main navigation) -->
          <nav class="collapse navbar-collapse" id="navbarNav">
            <div class="d-sm-none p-3 mt-n3">
              <a class="btn text-primary w-100 mb-1 mb-2" href="/sign-in" >
                <i class="ai-login fs-xl me-2 ms-n1"></i>
            login
              </a>
              <a class="btn btn-outline-primary w-100 mb-1" href="/sign-up">
                <i class="ai-user-group fs-xl me-2 ms-n1"></i>
                Became A Vendor
              </a>
            </div>
          </nav>
        </div>
      </header>


      <!-- Hero + Features -->
      <section class="bg-secondary position-relative pt-lg-3 pt-xl-4 pt-xxl-5">
        <div class="bg-primary position-absolute start-0 bottom-0 w-100 d-none d-xl-block" style="height: 920px;"></div>
        <div class="bg-primary position-absolute start-0 bottom-0 w-100 d-none d-lg-block d-xl-none" style="height: 830px;"></div>
        <div class="bg-primary position-absolute start-0 bottom-0 w-100 d-lg-none d-xl-none" style="height: 62%;"></div>
        <div class="bg-dark bg-opacity-10 rounded-circle position-absolute start-50 d-none d-lg-block" style="bottom: 220px; width: 480px; height: 480px; margin-left: -240px;" data-aos="zoom-in" data-aos-duration="700" data-aos-delay="200" data-aos-offset="300"></div>
        <div class="container position-relative z-5 mt-2 pt-5 pb-2 pb-sm-4 pb-lg-5">
          <h1 class="display-3 text-center mx-auto pt-5 my-2 my-sm-4" style="max-width: 680px;">Let's Make Your Wedding Epic</h1>
          <svg class="d-block mx-auto text-primary" width="511" height="40" viewBox="0 0 511 40" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path d="M385.252 0.160149C313.41 0.614872 292.869 0.910678 253.008 2.06539C211.7 3.26203 182.137 4.46154 135.231 6.84429C124.358 7.39665 112.714 7.92087 99.0649 8.47247C48.9242 10.4987 39.1671 11.0386 22.9579 12.6833C14.9267 13.4984 7.98117 14.0624 4.08839 14.2162C0.627411 14.3527 0 14.4386 0 14.7762C0 15.0745 5.53537 15.3358 8.56298 15.1804C9.64797 15.1248 12.5875 14.9887 15.0956 14.8782C17.6037 14.7676 23.123 14.4706 27.3608 14.2183C37.3399 13.6238 42.1312 13.4363 59.2817 12.9693C88.1133 12.1844 109.893 11.43 136.647 10.2898C146.506 9.86957 159.597 9.31166 165.737 9.04993C212.308 7.06466 269.195 5.29439 303.956 4.74892C346.139 4.08665 477.094 3.50116 474.882 3.98441C474.006 4.17607 459.021 5.6015 450.037 6.34782C441.786 7.03345 428 8.02235 411.041 9.14508C402.997 9.67773 391.959 10.4149 386.51 10.7832C366.042 12.1673 359.3 12.5966 347.67 13.2569C294.096 16.2987 258.708 18.9493 209.451 23.6091C180.174 26.3788 156.177 29.5584 129.396 34.2165C114.171 36.8648 112.687 37.3352 114.186 39.0402C115.161 40.1495 122.843 40.2933 138.338 39.492C166.655 38.0279 193.265 36.8923 219.043 36.048C235.213 35.5184 237.354 35.4296 253.795 34.6075C259.935 34.3005 270.549 33.8517 277.382 33.6105L289.804 33.1719L273.293 32.999C248.274 32.7369 221.435 32.7528 212.596 33.035C183.334 33.9693 167.417 34.6884 141.419 36.2506C135.222 36.623 129.994 36.8956 129.801 36.8566C127.94 36.4786 169.612 30.768 189.492 28.6769C234.369 23.956 280.582 20.4337 351.602 16.3207C358.088 15.9451 371.108 15.1233 380.535 14.4947C389.962 13.866 404.821 12.8761 413.556 12.2946C447.177 10.057 457.194 9.22358 489.506 5.97543C510.201 3.895 510.311 3.8772 510.875 2.50901C511.496 1.00469 509.838 0.322131 505.088 0.127031C500.576 -0.0584957 416.098 -0.0351424 385.252 0.160149ZM291.144 33.02C291.536 33.0658 292.102 33.0641 292.402 33.0162C292.703 32.9683 292.383 32.9308 291.691 32.9329C290.999 32.935 290.753 32.9743 291.144 33.02Z"></path>
          </svg>
          <div class="row justify-content-center pt-3 pt-sm-4 pt-md-5 mt-sm-1">
            <div class="col-8 col-lg-4 order-lg-2" style="margin-top: -105px;">

              <!-- Middle sticky app screen -->
              <div class="position-lg-sticky top-0 mb-5 pb-sm-2 pb-xl-4" style="padding-top: 110px;">
                <img class="d-block mx-auto" src="assets/img/app-layout/mockup-home.png" width="322" alt="App screen">
              </div>
            </div>

            <!-- Left column -->
            <div class="col-sm-6 col-lg-4 order-lg-1 overflow-hidden mt-lg-4 pt-xl-3">

              <!-- Left app sceen -->
              <img class="d-none d-lg-block rounded-4 ms-auto" src="assets/img/app-layout/mockup-my-bookings.png" width="297" alt="App screen" style="box-shadow: 0 .9375rem 3rem -.5rem rgba(18,34,50, .05);">
              <div class="d-none d-xxl-block" style="height: 310px;"></div>
              <div class="d-none d-xl-block d-xxl-none" style="height: 280px;"></div>
              <div class="d-none d-lg-block d-xl-none" style="height: 200px;"></div>

              <!-- Left features list -->
              <div class="text-center text-sm-start mb-5 mx-auto mx-sm-0 pb-lg-2 pb-xl-4" style="max-width: 340px;" data-aos="fade-right" data-aos-offset="300" data-aos-easing="ease-out-back" data-disable-parallax-down="lg">
                <div class="d-table bg-dark bg-opacity-10 rounded-1 p-2 mx-auto mx-sm-0 mb-3 mb-lg-4">
                  <i class="ai-calendar-check d-block m-1 text-warning"></i>
                </div>
                <h2 class="h4 text-white mb-2 mb-lg-3">Excellent Service</h2>
                <p class="text-white opacity-80 mb-0">encompassing nature of your services, including vendors, decoration, and budget management</p>
              </div>
              <div class="text-center text-sm-start mb-5 mx-auto mx-sm-0 pb-lg-2 pb-xl-4" style="max-width: 340px;" data-aos="fade-right" data-aos-delay="200" data-aos-offset="250" data-aos-easing="ease-out-back" data-disable-parallax-down="lg">
                <div class="d-table bg-dark bg-opacity-10 rounded-1 p-2 mx-auto mx-sm-0 mb-3 mb-lg-4">
                  <i class="ai-user-check d-block m-1 text-warning"></i>
                </div>
                <h2 class="h4 text-white mb-2 mb-lg-3">Vendor Network</h2>
                <p class="text-white opacity-80 mb-0">connects couples with trusted vendors, streamlining the planning process</p>
              </div>
            </div>

            <!-- Right column -->
            <div class="col-sm-6 col-lg-4 order-lg-3 overflow-hidden mt-lg-4 pt-xl-3">

              <!-- Right app screen -->
              <img class="d-none d-lg-block rounded-4" src="assets/img/app-layout/mockup-account.png" width="297" alt="App screen" style="box-shadow: 0 .9375rem 3rem -.5rem rgba(18,34,50, .05);">
              <div class="d-none d-xxl-block" style="height: 520px;"></div>
              <div class="d-none d-xl-block d-xxl-none" style="height: 490px;"></div>
              <div class="d-none d-lg-block d-xl-none" style="height: 400px;"></div>

              <!-- Right features list -->
              <div class="text-center text-sm-start mb-5 mx-auto me-sm-0 pb-lg-2 pb-xl-4" style="max-width: 340px;" data-aos="fade-left" data-aos-offset="250" data-aos-delay="400" data-aos-easing="ease-out-back" data-disable-parallax-down="lg">
                <div class="d-table bg-dark bg-opacity-10 rounded-1 p-2 mx-auto mx-sm-0 mb-3 mb-lg-4">
                  <i class="ai-clock d-block m-1 text-warning"></i>
                </div>
                <h2 class="h4 text-white mb-2 mb-lg-3">Creative Planning</h2>
                <p class="text-white opacity-80 mb-0">emphasizes your role in offering unique and inspiring ideas for the wedding.</p>
              </div>
              <div class="text-center text-sm-start mb-5 mx-auto me-sm-0 pb-lg-2 pb-xl-4" style="max-width: 340px;" data-aos="fade-left" data-aos-offset="200" data-aos-delay="600" data-aos-easing="ease-out-back" data-disable-parallax-down="lg">
                <div class="d-table bg-dark bg-opacity-10 rounded-1 p-2 mx-auto mx-sm-0 mb-3 mb-lg-4">
                  <i class="ai-pie-chart d-block m-1 text-warning"></i>
                </div>
                <h2 class="h4 text-white mb-2 mb-lg-3">Budget Expertise</h2>
                <p class="text-white opacity-80 mb-0">This showcases your skill in managing finances for a stress-free wedding.</p>
              </div>
            </div>
          </div>
        </div>
      </section>


      <!-- Stats -->
      <section class="container pt-5 mt-lg-3 mt-xl-4 mt-xxl-5">
        <div class="row pt-2 pt-sm-3 pt-md-4 pt-lg-5 pb-xxl-2 mt-md-3 mt-lg-0">
          <div class="col-lg-5 mb-5 mb-lg-0">
            <div class="h1 text-primary fw-light text-center text-lg-start pb-md-2 pb-xl-0 mb-4 mb-xl-5">A stylish event begins long before guests arrive. <p class="text-dark fw-500">It begins with masterful planning.</p></div>

            <!-- Market buttons -->
            <div class="d-flex justify-content-center justify-content-lg-start">
              <a class="btn btn-dark btn-lg px-3 py-2 me-3" href="/resources/apk/wedding-planner.apk" download>
                <i class="d-dark-mode-none mx-1 ai-download me-2"></i>
                <i class="d-none d-dark-mode-block mx-1 ai-download me-2"></i>
                Download Now
              </a>
            </div>
            
          </div>
          <div class="col-lg-7 col-xl-6 offset-xl-1">
            <div class="row row-cols-1 row-cols-sm-2 g-3 g-md-4">
              <div class="col">
                <div class="d-flex flex-column h-100 bg-primary bg-opacity-10 rounded-3 text-center p-4">
                  <div class="h3 display-5 mt-1 mb-0">1,000+</div>
                  <div class="fs-lg mb-1">Downloads per day</div>
                </div>
              </div>
              <div class="col">
                <div class="d-flex flex-column h-100 bg-info bg-opacity-10 rounded-3 text-center p-4">
                  <div class="h3 display-5 mt-1 mb-0">1 Million</div>
                  <div class="fs-lg mb-1">Users per month</div>
                </div>
              </div>
              <div class="col">
                <div class="d-flex flex-column h-100 bg-warning bg-opacity-10 rounded-3 text-center p-4">
                  <div class="h3 display-5 mt-1 mb-0">300+</div>
                  <div class="fs-lg mb-1">Vendors</div>
                </div>
              </div>
              <div class="col">
                <div class="d-flex flex-column h-100 bg-danger bg-opacity-10 rounded-3 text-center p-4">
                  <div class="h3 display-5 mt-1 mb-0">10</div>
                  <div class="fs-lg mb-1">States</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>


      <!-- Features (Binded slider) -->
      <section class="container pt-5 mt-lg-3 mt-xl-4 mt-xxl-5">
        <div class="row align-items-center pt-3 pt-sm-4 pt-lg-5 mt-md-3 mt-lg-0">
          <div class="col-md-6 pb-2 pb-sm-0 mb-4 mb-sm-5 mb-md-0">

            <!-- Binded images -->
            <div class="binded-content bg-primary rounded-5">

              <!-- Item -->
              <div class="binded-item active" id="image1">
                <svg class="d-block position-absolute top-0 start-0 w-100 h-100 text-warning" width="636" height="640" viewBox="0 0 636 640" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path d="M586.2,329.8c-0.2-2.9-0.6-5.8-1.3-8.6c-1.5-5.8-5.5-11-11.7-15c-5.5-3.6-12.7-6.1-20.2-7c-7.4-0.9-15-0.3-21.2,1.8c-6.9,2.3-12,6.2-14.9,11.3c-3.2,5.7-4,11.1-2.5,16.1c1.4,4.3,4.5,8,9.3,11.1c5.7,3.6,13.7,6.2,22.7,7.2c8.1,1,16,0.5,20.9-1.1c3.8-1.3,7.6-2.8,11.3-4.5c-2.6,11.4-10.3,23.2-22.8,35.1c-26.2,24.9-67.3,43.8-88.6,50.5c-1.7,0.5-2.7,2.4-2.1,4.1c0.3,0.8,0.8,1.5,1.6,1.9c0.5,0.2,1,0.4,1.5,0.4c0.3,0,0.7,0,1-0.2c18.8-5.9,62.1-24.3,91.2-52c15.2-14.5,23.8-29.1,25.6-43.5c18.6-10.1,35.1-24.9,50-40.7v-9.5C621.1,303.4,604.7,319,586.2,329.8z M565.3,339.3c-4.3,1.4-11.1,1.8-18.2,0.9c-7.9-1-15-3.2-19.9-6.4c-3.5-2.2-5.7-4.7-6.5-7.5c-1-3.1-0.3-6.8,2-10.9c1.7-3.1,4.6-5.5,8.5-7.3c4.3-1.9,9.5-2.9,15-2.9c2,0,4,0.1,6.1,0.4c6.3,0.8,12.3,2.8,16.9,5.5c2.5,1.5,4.6,3.3,6.2,5.3c1.6,1.9,2.7,4.1,3.3,6.3c0.9,3.5,1.3,7,1.2,10.5C575,335.7,570.1,337.7,565.3,339.3z"></path>
                  <path d="M140.2,52.6c-1.2-9-6.2-17.2-12-24c-0.8-0.9-2.1-1-3-0.2c-0.9,0.8-1,2.1-0.2,3c5.3,6.2,10,13.6,11,21.8c0.1,1.2,1.2,2,2.4,1.8C139.5,54.9,140.3,53.8,140.2,52.6z"></path>
                  <path d="M124.1,72.9c-6.1,0.3-11.5,2-17.2,3.6c-1.1,0.3-1.8,1.5-1.5,2.6c0.3,1.1,1.5,1.8,2.6,1.5c5.5-1.5,10.6-3.1,16.3-3.4c1.2-0.1,2.1-1,2-2.2C126.2,73.7,125.3,72.8,124.1,72.9z"></path>
                  <path d="M131.5,57.8c-11.4-6.8-25.1-12.4-38.2-15.2c-1.1-0.2-2.3,0.5-2.5,1.6c-0.2,1.1,0.5,2.3,1.6,2.5c12.6,2.8,25.9,8.1,36.9,14.7c1,0.6,2.3,0.3,2.9-0.7C132.8,59.7,132.5,58.4,131.5,57.8z"></path>
                </svg>
                <img class="d-block position-relative z-2" src="assets/img/app-layout/mockup-vendors.png" alt="App screen">
              </div>

              <!-- Item -->
              <div class="binded-item" id="image2">
                <svg class="d-block position-absolute top-0 start-0 w-100 h-100 text-warning" width="636" height="640" viewBox="0 0 636 640" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path d="M412.197 -54.1417C409.01 -50.153 404.449 -45.0689 396.393 -36.5235C378.652 -17.7043 368.395 -4.20178 339.64 38.1888C320.084 67.0197 313.732 75.6921 305.904 84.2505C302.46 88.0158 296.937 91.7681 294.312 92.1252C293.471 92.2398 292.661 91.7642 292.353 90.9757L292.291 90.8173C290.997 87.5076 290.656 82.5981 290.886 70.6154C291.253 51.5223 290.257 44.8019 286.15 38.6548C276.062 23.5577 257.645 38.0693 231.392 81.802C229.48 84.987 223.898 94.9317 218.988 103.901C199.782 138.985 195.822 145.462 192.294 147.561L191.853 147.823C191.125 148.256 190.18 147.984 189.793 147.231C188.667 145.037 187.961 141.017 186.717 129.714C184.189 106.732 180.914 98.5708 173.15 95.8985C165.844 93.3837 153.123 103.378 140.69 121.402C131.347 134.945 113.831 166.078 91.0128 209.694C69.8233 250.198 66.3837 256.187 64.5396 255.784C63.9143 255.647 63.7312 251.161 63.5858 232.448C63.305 196.288 62.4571 188.893 57.6271 180.481C48.7649 165.045 38.9039 173.309 18.4076 213.349C4.9308 239.676 -5.25857 266.339 -16.531 304.775C-22.481 325.063 -23.547 329.347 -22.9161 330.435C-22.4361 331.262 -21.607 330.886 -21.8104 329.933C-21.9715 329.175 -19.829 322.329 -16.6872 313.564C-15.5519 310.397 -13.4645 304.212 -12.0486 299.819C-5.17897 278.51 8.39215 243.529 15.5497 228.681C28.8615 201.067 39.4459 183.801 45.7893 179.352C49.4163 176.808 50.6601 177.421 53.7621 183.285C57.7184 190.764 58.7369 200.207 59.1715 233.43C59.5061 259.004 59.9209 261.21 64.3216 260.814C69.8899 260.313 73.9997 254.012 96.5793 211.354C137.787 133.504 155.164 107.073 168.666 101.708C175.088 99.156 179.298 108.555 181.934 131.331C183.982 149.026 185.558 153.247 190.21 153.495C196.679 153.841 201.275 147.557 225.333 105.473C246.313 68.7723 259.369 50.518 270.19 42.7571C276.503 38.2285 278.497 38.5429 281.567 44.5509C284.012 49.336 284.551 54.6178 284.232 70.6599C283.754 94.6223 286.717 101.264 296.665 98.5284C307.305 95.6024 314.857 86.8209 345.622 41.5992C362.049 17.4536 367.831 9.29258 380.682 -7.88343C385.241 -13.9779 391.495 -22.7637 394.579 -27.4072C397.663 -32.051 402.878 -39.7522 406.167 -44.5213C409.456 -49.2904 412.734 -54.0439 413.452 -55.0844C415.191 -57.6056 414.626 -57.1815 412.197 -54.1417Z"></path>
                </svg>
                <img class="d-block position-relative z-2" src="assets/img/app-layout/mockup-service.png" alt="App screen">
              </div>

              <!-- Item -->
              <div class="binded-item" id="image3">
                <svg class="d-block position-absolute top-0 start-0 w-100 h-100 text-warning" width="636" height="640" viewBox="0 0 636 640" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path d="M183.271 -81.2966C186.59 -77.143 191.339 -71.8486 199.728 -62.9498C218.204 -43.3523 228.885 -29.2913 258.828 14.8524C279.194 44.8757 285.808 53.9067 293.96 62.819C297.546 66.74 303.298 70.6475 306.031 71.0195C306.907 71.1387 307.751 70.6435 308.072 69.8223L308.136 69.6575C309.483 66.2108 309.839 61.0983 309.599 48.6201C309.217 28.7373 310.254 21.739 314.531 15.3377C325.036 -0.383858 344.214 14.7279 371.554 60.2693C373.545 63.586 379.357 73.942 384.471 83.2827C404.47 119.817 408.595 126.562 412.268 128.748L412.727 129.02C413.486 129.471 414.47 129.189 414.873 128.404C416.046 126.119 416.781 121.933 418.076 110.163C420.709 86.2303 424.119 77.7316 432.204 74.9488C439.812 72.3299 453.06 82.7381 466.007 101.507C475.736 115.61 493.977 148.031 517.738 193.451C539.804 235.63 543.386 241.866 545.306 241.447C545.957 241.304 546.148 236.632 546.299 217.146C546.592 179.49 547.475 171.789 552.505 163.029C561.733 146.955 572.002 155.561 593.346 197.256C607.38 224.673 617.991 252.438 629.73 292.464C635.926 313.591 637.036 318.052 636.379 319.185C635.879 320.047 635.016 319.655 635.227 318.662C635.395 317.873 633.164 310.743 629.892 301.617C628.71 298.318 626.536 291.877 625.062 287.303C617.908 265.112 603.776 228.685 596.322 213.222C582.46 184.466 571.438 166.487 564.832 161.853C561.055 159.204 559.76 159.843 556.529 165.949C552.41 173.737 551.349 183.571 550.896 218.168C550.548 244.8 550.116 247.097 545.533 246.685C539.735 246.163 535.455 239.601 511.941 195.179C469.03 114.109 450.934 86.5855 436.873 80.9983C430.186 78.341 425.802 88.1292 423.057 111.846C420.924 130.274 419.283 134.669 414.438 134.928C407.702 135.288 402.916 128.744 377.863 84.9195C356.015 46.7007 342.419 27.6914 331.151 19.6096C324.576 14.8938 322.5 15.2211 319.303 21.4776C316.757 26.4606 316.195 31.9608 316.528 48.6664C317.026 73.6198 313.94 80.5362 303.581 77.6874C292.501 74.6404 284.636 65.4957 252.599 18.4038C235.493 -6.74031 229.472 -15.2389 216.09 -33.1252C211.341 -39.4717 204.829 -48.6209 201.617 -53.4564C198.406 -58.2923 192.976 -66.312 189.55 -71.2784C186.125 -76.2447 182.712 -81.1947 181.964 -82.2783C180.153 -84.9037 180.741 -84.4621 183.271 -81.2966Z"></path>
                </svg>
                <img class="d-block position-relative z-2" src="assets/img/app-layout/mockup-inspiration.png" alt="App screen">
              </div>
            </div>
          </div>
          <div class="col-md-6 col-xl-5 offset-xl-1">
            <div class="ps-md-4 ps-xl-0">

              <!-- Swiper slider -->
              <div class="swiper" data-swiper-options='{
                "spaceBetween": 30,
                "autoHeight": true,
                "bindedContent": true,
                "navigation": {
                  "prevEl": "#prev-feature",
                  "nextEl": "#next-feature"
                }
              }'>
                <div class="swiper-wrapper">

                  <!-- Item -->
                  <div class="swiper-slide" data-swiper-binded="#image1">
                    <div class="text-primary fs-xl fw-bold mb-3">01</div>
                    <h2 class="h1 mb-lg-4">Whatever you need, whenever you need !</h2>
                    <p class="mb-0">Browse your favorite vendors</p>
                  </div>

                  <!-- Item -->
                  <div class="swiper-slide" data-swiper-binded="#image2">
                    <div class="text-primary fs-xl fw-bold mb-3">02</div>
                    <h2 class="h1 mb-lg-4">Looking for your favorite services ?</h2>
                    <p class="mb-0"> Well they are at your finger tips !</p>
                  </div>

                  <!-- Item -->
                  <div class="swiper-slide" data-swiper-binded="#image3">
                    <div class="text-primary fs-xl fw-bold mb-3">03</div>
                    <h2 class="h1 mb-lg-4">Want to share your ideas to others ? </h2>
                    <p class="mb-0">Well inspire them with your ..... thinking</p>
                  </div>
                </div>
              </div>

              <!-- Slider controls (Prev / Next) -->
              <div class="d-flex justify-content-center justify-content-md-start pt-4 mt-2 mt-lg-0 pt-lg-5">
                <button class="btn btn-icon btn-outline-primary rounded-circle me-3" type="button" id="prev-feature" aria-label="Prev">
                  <i class="ai-arrow-left"></i>
                </button>
                <button class="btn btn-icon btn-outline-primary rounded-circle" type="button" id="next-feature" aria-label="Next">
                  <i class="ai-arrow-right"></i>
                </button>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Testimonials carousel -->
      <section class="container py-5 mb-1 mb-sm-2 my-lg-3 my-xl-4 my-xxl-5">
        <div class="row justify-content-center pt-2 pt-sm-4 pb-4 mb-2 mb-lg-3">
          <div class="col-lg-8 col-xl-7 col-xxl-6 text-center pt-2">
            <h2 class="h1 mb-1">Testimonials</h2>
          </div>
        </div>
        <div class="swiper pb-2 pb-sm-4" data-swiper-options='{
          "slidesPerView": 1,
          "spaceBetween": 24,
          "loop": true,
          "pagination": {
            "el": ".swiper-pagination",
            "clickable": true
          },
          "breakpoints": {
            "800": {
              "slidesPerView": 2
            }
          }
        }'>
          <div class="swiper-wrapper pt-5">

            <!-- Item -->
            <div class="swiper-slide h-auto">
              <div class="card border-0 bg-info bg-opacity-10 h-100 text-center">
                <div class="polygon-avatar bg-info mx-auto translate-middle-y">
                  <img src="assets/img/landing/mobile-app-showcase/testimonials/01.png" alt="Nick Williams">
                </div>
                <div class="card-body pt-0 mt-n4">
                  <p class="card-text fs-xl">I can't thank <b>Wedding Planner</b> enough for their incredible work. They went above and beyond to make sure every aspect of our wedding was perfect. Their team's expertise and creativity exceeded our expectations. Thank you for making our dream wedding come true!</p>
                </div>
                <div class="card-footer border-0 pt-0">
                  <div class="h4 mb-1">Joshi Vijay</div>
                  <span>Groom</span>
                </div>
              </div>
            </div>

            <!-- Item -->
            <div class="swiper-slide h-auto">
              <div class="card border-0 bg-warning bg-opacity-10 h-100 text-center">
                <div class="polygon-avatar bg-warning mx-auto translate-middle-y">
                  <img src="assets/img/landing/mobile-app-showcase/testimonials/02.png" alt="Lili Bocouse">
                </div>
                <div class="card-body pt-0 mt-n4">
                  <p class="card-text fs-xl">Working with <b>Wedding Planner</b> was an absolute delight! From start to finish, they listened to our vision and turned it into a beautiful reality. Their attention to detail and professionalism made our special day truly unforgettable. Highly recommend!</p>
                </div>
                <div class="card-footer border-0 pt-0">
                  <div class="h4 mb-1">Nisha Raval</div>
                  <span>Bride</span>
                </div>
              </div>
            </div>

            <!-- Item -->
            <div class="swiper-slide h-auto">
              <div class="card border-0 bg-primary bg-opacity-10 h-100 text-center">
                <div class="polygon-avatar bg-primary mx-auto translate-middle-y">
                  <img src="assets/img/landing/mobile-app-showcase/testimonials/04.png" alt="Esther Howard">
                </div>
                <div class="card-body pt-0 mt-n4">
                  <p class="card-text fs-xl">Choosing <b>Wedding Planner</b> was the best decision we made for our wedding. They took care of everything seamlessly, allowing us to enjoy every moment of our big day. Their dedication and passion for what they do truly shine through in their work. Thank you for making our wedding day so magical!</p>
                </div>
                <div class="card-footer border-0 pt-0">
                  <div class="h4 mb-1">Digvijay Jankhaniya</div>
                  <span>Groom</span>
                </div>
              </div>
            </div>

            <!-- Item -->
            <div class="swiper-slide h-auto">
              <div class="card border-0 bg-danger bg-opacity-10 h-100 text-center">
                <div class="polygon-avatar bg-danger mx-auto translate-middle-y">
                  <img src="assets/img/landing/mobile-app-showcase/testimonials/03.png" alt="Jane Cooper">
                </div>
                <div class="card-body pt-0 mt-n4">
                  <p class="card-text fs-xl">We are so grateful to <b>Wedding Planner</b> for their exceptional service. They were with us every step of the way, offering valuable advice and ensuring that every detail was executed flawlessly. Our wedding was everything we hoped for and more, thanks to their expertise and professionalism.</p>
                </div>
                <div class="card-footer border-0 pt-0">
                  <div class="h4 mb-1">Shreya Acharya</div>
                  <span>Bride</span>
                </div>
              </div>
            </div>
          </div>

          <!-- Pagination (bullets) -->
          <div class="swiper-pagination position-relative bottom-0 mt-2 mt-lg-3 pt-4"></div>
        </div>
      </section>


      <!-- FAQ (Accordion) -->
      <section class="bg-secondary py-5">
        <div class="container py-md-2 py-lg-3 py-xl-5 my-2 my-sm-3 my-md-4 my-xxl-5">
          <div class="row">
            <div class="col-md-4 text-center text-md-start">
              <h2 class="h1">Any questions?</h2>
              <p class="pb-3 pb-sm-4">Check out the FAQ</p>
              <div class="d-none d-md-flex justify-content-center">
                <svg class="text-warning ms-n4" width="200" height="211" viewBox="0 0 200 211" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M198.804 194.488C189.279 189.596 179.529 185.52 169.407 182.07L169.384 182.049C169.227 181.994 169.07 181.939 168.912 181.884C166.669 181.139 165.906 184.546 167.669 185.615C174.053 189.473 182.761 191.837 189.146 195.695C156.603 195.912 119.781 196.591 91.266 179.049C62.5221 161.368 48.1094 130.695 56.934 98.891C84.5539 98.7247 112.556 84.0176 129.508 62.667C136.396 53.9724 146.193 35.1448 129.773 30.2717C114.292 25.6624 93.7109 41.8875 83.1971 51.3147C70.1109 63.039 59.63 78.433 54.2039 95.0087C52.1221 94.9842 50.0776 94.8683 48.0703 94.6608C30.1803 92.8027 11.2197 83.6338 5.44902 65.1074C-1.88449 41.5699 14.4994 19.0183 27.9202 1.56641C28.6411 0.625793 27.2862 -0.561638 26.5419 0.358501C13.4588 16.4098 -0.221091 34.5242 0.896608 56.5659C1.8218 74.6941 14.221 87.9401 30.4121 94.2058C37.7076 97.0203 45.3454 98.5003 53.0334 98.8449C47.8679 117.532 49.2961 137.487 60.7729 155.283C87.7615 197.081 139.616 201.147 184.786 201.155L174.332 206.827C172.119 208.033 174.345 211.287 176.537 210.105C182.06 207.125 187.582 204.122 193.084 201.144C193.346 201.147 195.161 199.887 195.423 199.868C197.08 198.548 193.084 201.144 195.528 199.81C196.688 199.192 197.846 198.552 199.006 197.935C200.397 197.167 200.007 195.087 198.804 194.488ZM60.8213 88.0427C67.6894 72.648 78.8538 59.1566 92.1207 49.0388C98.8475 43.9065 106.334 39.2953 114.188 36.1439C117.295 34.8947 120.798 33.6609 124.168 33.635C134.365 33.5511 136.354 42.9911 132.638 51.031C120.47 77.4222 86.8639 93.9837 58.0983 94.9666C58.8971 92.6666 59.783 90.3603 60.8213 88.0427Z" fill="currentColor"></path>
                </svg>
              </div>
            </div>
            <div class="col-md-8 col-lg-7 offset-lg-1">
              <div class="accordion" id="faq">
                <div class="accordion-item bg-light">
                  <h3 class="accordion-header" id="headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#questionOne" aria-expanded="true" aria-controls="questionOne">What is a wedding planner app?</button>
                  </h3>
                  <div class="accordion-collapse collapse show" id="questionOne" aria-labelledby="headingOne" data-bs-parent="#faq">
                    <div class="accordion-body fs-sm">A wedding planner app is a digital tool designed to help users plan and organize their weddings efficiently.</div>
                  </div>
                </div>
                <div class="accordion-item bg-light">
                  <h3 class="accordion-header" id="headingTwo">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#questionTwo" aria-expanded="false" aria-controls="questionTwo">What features does the wedding planner app offer?</button>
                  </h3>
                  <div class="accordion-collapse collapse" id="questionTwo" aria-labelledby="headingTwo" data-bs-parent="#faq">
                    <div class="accordion-body fs-sm">The app typically offers features such as budget management, vendor management, checklist creation, wedding day timeline and much more.</div>
                  </div>
                </div>
                <div class="accordion-item bg-light">
                  <h3 class="accordion-header" id="headingThree">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#questionThree" aria-expanded="false" aria-controls="questionThree">Is the wedding planner app free to use?</button>
                  </h3>
                  <div class="accordion-collapse collapse" id="questionThree" aria-labelledby="headingThree" data-bs-parent="#faq">
                    <div class="accordion-body fs-sm">Yes it is absolutely free for consumers.</div>
                  </div>
                </div>
                <div class="accordion-item bg-light">
                  <h3 class="accordion-header" id="headingFour">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#questionFour" aria-expanded="false" aria-controls="questionFour">Can I collaborate with my partner or wedding planner through the app?</button>
                  </h3>
                  <div class="accordion-collapse collapse" id="questionFour" aria-labelledby="headingFour" data-bs-parent="#faq">
                    <div class="accordion-body fs-sm">No, but you can see their progress on each step.</div>
                  </div>
                </div>
                <div class="accordion-item bg-light">
                  <h3 class="accordion-header" id="headingSix">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#questionSix" aria-expanded="false" aria-controls="questionSix">Does the app provide vendor recommendations?</button>
                  </h3>
                  <div class="accordion-collapse collapse" id="questionSix" aria-labelledby="headingSix" data-bs-parent="#faq">
                    <div class="accordion-body fs-sm">Yes, wedding planner app offers vendor directories or recommendations based on location, budget, and user reviews to help users find and hire wedding vendors such as photographers, florists, and caterers.</div>
                  </div>
                </div>
                <div class="accordion-item bg-light">
                  <h3 class="accordion-header" id="headingSeven">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#questionSeven" aria-expanded="false" aria-controls="questionSeven">What support options are available if I have questions or issues with the app?</button>
                  </h3>
                  <div class="accordion-collapse collapse" id="questionSeven" aria-labelledby="headingSeven" data-bs-parent="#faq">
                    <div class="accordion-body fs-sm">wedding planner app offers customer support through email, chat, or FAQs within the app to assist users with any questions or technical issues they may encounter.</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>


      <!-- CTA -->
      <section class="bg-secondary">
        <div class="container">
          <div class="position-relative overflow-hidden rounded-5 px-4 px-sm-5 px-lg-0">
            <div class="bg-primary rounded-5 position-absolute top-0 start-0 w-100 h-100" data-aos="zoom-in" data-aos-duration="600" data-aos-offset="300" data-disable-parallax-down="lg"></div>
            <div class="row align-items-center position-relative z-2">
              <div class="col-md-6 col-lg-5 col-xl-4 offset-lg-1 pb-sm-3 pt-5 py-md-0 py-lg-5" data-aos="fade-up" data-aos-duration="500" data-aos-offset="250" data-disable-parallax-down="lg">
                <h2 class="display-3 text-white text-center text-md-start mb-4 mb-lg-5">Ready to <br class="d-none d-xxl-inline">Get Started?</h2>

                <!-- Market buttons -->
                <div class="d-flex flex-column flex-sm-row justify-content-center justify-content-md-start">
                  <a class="btn btn-light btn-lg px-3 py-2 me-sm-3 mb-3 mb-sm-0" href="/resources/apk/wedding-planner.apk">
                    <i class="ai-download me-2"></i>
                    Download Now
                  </a>
                </div>

              </div>
              <div class="col-md-6 col-lg-5 offset-xl-1">

                <!-- Image visible on screens < 768px -->
                <img class="d-block d-md-none mx-auto" src="assets/img/app-layout/mockup-screens-demo-transparent.png" width="420" alt="App screen">

                <!-- Image visible on screens > 768px -->
                <div class="d-none d-md-block position-relative mx-auto" style="max-width: 480px;">
                  <div class="position-absolute top-0 start-0 w-100 h-100" data-aos="zoom-in" data-aos-duration="400" data-aos-delay="600" data-aos-offset="300" data-aos-easing="ease-out-back" data-disable-parallax-down="lg">
                    <svg class="text-warning position-absolute top-0 start-0 w-100 h-100" width="484" height="590" viewBox="0 0 484 590" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                      <path d="M35.0852 77.896C29.0293 78.1976 23.6248 79.9148 17.8537 81.4616C16.7267 81.7638 16.0606 82.9197 16.3605 84.0437C16.6606 85.1684 17.8209 85.8347 18.9481 85.5331C24.4203 84.0662 29.5448 82.3932 35.2968 82.1056C36.4603 82.0476 37.3589 81.0561 37.2973 79.8952C37.2427 78.7329 36.2485 77.8374 35.0852 77.896Z"></path>
                      <path d="M42.4929 62.8378C31.073 56.0023 17.3524 50.4482 4.32343 47.5959C3.18562 47.3476 2.05922 48.0685 1.81258 49.2044C1.56593 50.3402 2.28436 51.4658 3.42217 51.7141C16.0197 54.4726 29.2896 59.844 40.327 66.4552C41.3271 67.052 42.6231 66.7263 43.2192 65.7286C43.8152 64.7309 43.493 63.4346 42.4929 62.8378Z"></path>
                      <path d="M51.1742 57.6399C50.0172 48.6073 44.9377 40.4608 39.1682 33.66C38.4115 32.7739 37.0807 32.6648 36.1979 33.4154C35.3087 34.1687 35.2011 35.4998 35.9511 36.3879C41.2085 42.5807 45.9377 49.949 46.9927 58.1754C47.1402 59.3297 48.1987 60.1459 49.3501 59.9984C50.5016 59.8517 51.3216 58.7935 51.1742 57.6399Z"></path>
                    </svg>
                  </div>
                  <img src="assets/img/app-layout/mockup-screens-demo-transparent.png" class="ms-2z mt-5" alt="App screens" data-aos="fade-left" data-aos-duration="600" data-aos-delay="200" data-aos-offset="300" data-disable-parallax-down="lg">
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </main>
    

    <!-- Footer -->
    <footer class="footer bg-secondary py-5">
      <div class="container pt-md-2 pt-lg-3 pt-xl-4">
        <div class="row pb-4 pb-md-5 pt-sm-2 mb-lg-2">
          <div class="col-md-6 pb-2 pb-md-0 mb-4 mb-md-0 d-flex justify-content-start">
            <a class="navbar-brand text-nav py-0 mb-3 mb-md-4" data-scroll href="#top">
              <span class="text-primary flex-shrink-0 me-2">
                <img src="assets/app-icons/logo.png" width="150" alt="Wedding Planner" />
              </span>
            </a>
            </div>
            <div class="col-md-6 pb-2 pb-md-0 mb-4 mb-md-0 d-flex justify-content-end">
            <p class="fs-sm pb-2 pb-md-3 mb-3">Let's Make Your Wedding Epic.</p>
          </div>
          <!-- 
          <div class="col-md-4 pb-2 pb-md-0 mb-4 mb-md-0">
            <div class="d-flex gap-5 justify-content-center">
              <a class="btn btn-icon btn-sm btn-secondary btn-facebook rounded-circle" href="#" aria-label="Facebook">
                <i class="ai-facebook"></i>
              </a>
              <a class="btn btn-icon btn-sm btn-secondary btn-instagram rounded-circle" href="#" aria-label="Instagram">
                <i class="ai-instagram"></i>
              </a>
              <a class="btn btn-icon btn-sm btn-secondary btn-linkedin rounded-circle" href="#" aria-label="LinnkedIn">
                <i class="ai-linkedin"></i>
              </a>
            </div>
          </div>
           -->
        </div>
        <div class="d-flex justify-content-center">
	        <p class="nav fs-sm mb-0">
	          <span class="text-body-secondary">&copy; All rights reserved. </span>
	          <a class="nav-link d-inline fw-normal p-0 ms-1" data-scroll href="#top">Wedding Planner</a>
	        </p>
        </div>
      </div>
    </footer>
  

    <!-- Back to top button -->
    <a class="btn-scroll-top" href="#top" data-scroll aria-label="Scroll back to top">
      <svg viewBox="0 0 40 40" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <circle cx="20" cy="20" r="19" fill="none" stroke="currentColor" stroke-width="1.5" stroke-miterlimit="10"></circle>
      </svg>
      <i class="ai-arrow-up"></i>
    </a>


    <!-- Vendor scripts: JS libraries and plugins -->
    <script src="assets/vendor/parallax-js/dist/parallax.min.js"></script>
    <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
    <script src="assets/vendor/aos/dist/aos.js"></script>

    <!-- Bootstrap + Theme scripts -->
    <script src="assets/js/theme.min.js"></script>

	<script type="text/javascript">
	window.addEventListener("load", () => {
		if ("serviceWorker" in navigator) {
		navigator.serviceWorker.register("service-worker.js");
		}
	});
	</script>

  </body>
</html>
