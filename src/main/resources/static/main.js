console.log('Hello my name is Roman');

let sendButton = document.getElementById('sendMessage');
let connectButton = document.getElementById('connect');
let inputText = document.getElementById('inputText');
let disconnect = document.getElementById('disconnect');
let byId = document.getElementById('messageText');
let stompClient = null;
let $inputText = $('#inputText');

connectButton.onclick = function () {

    let socket = new SockJS("/entryPoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        console.log('Законектились');
        stompClient.subscribe('/chanel/room', function (answer) {
            console.log('Ми підписані');
            let p = document.createElement('p');
            p.innerText = JSON.parse(answer.body).outMsg;
            byId.append(p);

            p.style.fontSize = "15px";
            p.style.color = "darkred";
            p.style.border = "darkorange";
            p.style.width = "100%";
            p.style.background = "azure";
            p.style.padding = "5px 3px";
            p.style.borderRadius = "10px";
            p.style.marginBottom = "3px";
        })
    });
};

sendButton.onclick = function () {
    let text = inputText.value;
    $inputText.val();
    stompClient.send('/prefixForSendMessage/message', {}, JSON.stringify({msg: text}))
    $inputText.val('');
};

disconnect.onclick = function () {
    stompClient.disconnect();
};

