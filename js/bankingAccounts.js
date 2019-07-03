
var AccountFactory = function () {
    let name="", deposit=0; //private data
    function createAccount() { //private inner function
        this.name = document.getElementById("accountName").value;
        this.deposit = document.getElementById("deposit").value;
        return {
            name: this.name,
            deposit: this.deposit
        };
    }

    return { // three public functions are closures
        createNewAccount: function () { return createAccount(); },
    }
};

window.onload = () => {
    document.getElementById("addDeposit").onclick = () => {
        var newAccount = AccountFactory();
        var line=newAccount.createNewAccount();
        var textArea = document.getElementById("textArea");
        textArea.value += `Account Name: ${line.name}   Deposit: ${line.deposit}\n`;
    };
};


