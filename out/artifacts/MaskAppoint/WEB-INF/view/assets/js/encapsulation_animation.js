function getAtrributeValues( obj , attr ) {
    if(obj.currentStyle){
        return obj.currentStyle
    }else {
        return window.getComputedStyle(obj , null)[attr];
    }
};
function slowMotion(showObject,json,fn) {
    clearInterval(showObject.timer);

    var speed = 0 , begin = 0 , target = 0 , flag = false;

    showObject.timer = setInterval(function () {

        flag = true;

        for ( var key in json ) {
            if(key === 'opacity') {
                begin = parseInt(getAtrributeValues(showObject , key) * 100) || 100;
                target = parseInt(json[key] * 100);
            }else if( key === 'scrollTop' ){
                begin = Math.ceil(Number(showObject.scrollTop));
                target = parseInt(json[key]);
            } else {
                begin = parseInt(getAtrributeValues(showObject , key)) || 0;
                target =  parseInt(json[key]);
            }

            speed = (target - begin) * 0.2;
            speed = (target > begin) ? Math.ceil(speed) : Math.floor(speed);

            if(key === 'opacity'){
                showObject.style.opacity = (begin + speed)/100;
            }else if(key === 'scrollTop'){
                showObject.scrollTop = begin + speed;
            }else if(key === 'zIndex'){
                showObject.style[key] = json[key];
            }else {
                showObject.style[key] = begin + speed + 'px';
            }

            if(begin !== target){
                flag = false;
            }
        }

        if(flag) {
            clearInterval(showObject.timer);
            if(fn){
                fn();
            }
        }
    },40);
};
