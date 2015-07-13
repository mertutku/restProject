var controller = new Vue({

	el: '#myapp',

	data: {
		customers: [
		],

		newCustomer: {
			name: '',
			surname: ''
		}
	},

	methods: {

		addCustomer: function() {
			var that = this;

			$.ajax({
				type: 'POST',
				url: '../../store/customer/add',
				contentType: 'application/json',
				data: JSON.stringify(that.newCustomer)
			}).done(function() {
				that.customers.push(that.newCustomer);
				that.newCustomer = { name: '', surname: '' };
				that.$$.txtName.focus();
			});
		}
	}
});

$(function() {

	$.get('../../store/customer/list', function(data) {
		controller.customers = controller.customers.concat(data);
	});
});

