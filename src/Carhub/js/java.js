(function () {
    const nachalo = document.querySelector('.nachalo');
    window.onscroll = () => {
        if (window.pageYOffset > 50) {
            nachalo.classList.add('nachalo_active');
        } else {
            nachalo.classList.remove('nachalo_active');
        }
    };
}());

// Burger handler
(function () {
    const burgerItem = document.querySelector('.burger');
    const menu = document.querySelector('.nachalo__nav');
    const menuCloseItem = document.querySelector('.nachalo__nav-close');
    const menuLinks = document.querySelectorAll('.nachalor__connect');
    burgerItem.addEventListener('click', () => {
        menu.classList.add('nachalo__nav_active');
    });
    menuCloseItem.addEventListener('click', () => {
        menu.classList.remove('nachalo__nav_active');
    });
    if (window.innerWidth <= 767) {
        for (let i = 0; i < menuLinks.length; i += 1) {
            menuLinks[i].addEventListener('click', () => {
                menu.classList.remove('nachalo__nav_active');
            });
        }
    }
}());

// Scroll to anchors
(function () {

    const smoothScroll = function (targetEl, duration) {
        const nachaloElHeight =  document.querySelector('.nachalo').clientHeight;
        let target = document.querySelector(targetEl);
        let targetPosition = target.getBoundingClientRect().top - nachaloElHeight;
        let startPosition = window.pageYOffset;
        let startTime = null;
    
        const ease = function(t,b,c,d) {
            t /= d / 2;
            if (t < 1) return c / 2 * t * t + b;
            t--;
            return -c / 2 * (t * (t - 2) - 1) + b;
        };
    
        const animation = function(currentTime){
            if (startTime === null) startTime = currentTime;
            const timeElapsed = currentTime - startTime;
            const run = ease(timeElapsed, startPosition, targetPosition, duration);
            window.scrollTo(0,run);
            if (timeElapsed < duration) requestAnimationFrame(animation);
        };
        requestAnimationFrame(animation);

    };

    const scrollTo = function () {
        const links = document.querySelectorAll('.js-scroll');
        links.forEach(each => {
            each.addEventListener('click', function () {
                const currentTarget = this.getAttribute('href');
                smoothScroll(currentTarget, 1000);
            });
        });
    };
    scrollTo();
}());

