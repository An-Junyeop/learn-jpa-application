const modal = {
    modal: document.getElementsByClassName('modal')[0],
    closeButton: document.getElementsByClassName('btn-cancel'),

    // Modal init
    initModal () {
        // input 초기화
        Array.from(this.modal.getElementsByClassName('modal-input')).forEach(function (input) {
            input.value = '';
        });
        this.modal.dispatchEvent(new CustomEvent('destroy'));
        this.modal.style.display = 'none';
    },

    // Modal close event
    modalCloseEvent () {
        const _this = this;

        Array.from(this.closeButton).forEach(function (button) {
            button.addEventListener('click', function () {
                _this.initModal();
            });
        })
    },

    // Modal open event binding
    modalOpenEventBinding (openButton) {
        const _this = this;

        // openButton이 배열 형태인 경우
        if (openButton instanceof HTMLCollection) {
            Array.from(openButton).forEach(function (button) {
                button.addEventListener('click', function () {
                    _this.modalOpenEvent(this.dataset.type);
                });
            });
        // openButton이 단일 태그인 경우
        } else {
            openButton.addEventListener('click', function () {
                _this.modalOpenEvent(this.dataset.type);
            });
        }
    },

    modalOpenEvent (type) {
        this.modal.dispatchEvent(new CustomEvent('build', {
            detail : type
        }));
        this.modal.setAttribute('style', 'display: flex; display: -ms-flex;');
    }

}

modal.modalCloseEvent();