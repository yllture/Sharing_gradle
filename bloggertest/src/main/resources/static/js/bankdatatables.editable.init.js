/**
 * Theme: Montran Admin Template
 * Author: Coderthemes
 * Component: Editable
 * 
 */

(function($) {

	'use strict';

	var EditableTable = {

		options: {
			addButton: '#addToTable',
			table: '#datatable-editable',
			dialog: {
				wrapper: '#dialog',
				cancelButton: '#dialogCancel',
				confirmButton: '#dialogConfirm',
			}
		},

		initialize: function() {
			this
				.setVars()
				.build()
				.events();
		},

		setVars: function() {
			this.$table = $(this.options.table);
			this.$addButton = $(this.options.addButton);

			// dialog
			this.dialog = {};
			this.dialog.$wrapper = $(this.options.dialog.wrapper);
			this.dialog.$cancel = $(this.options.dialog.cancelButton);
			this.dialog.$confirm = $(this.options.dialog.confirmButton);

			return this;
		},

		build: function() {
			this.datatable = this.$table.DataTable({
				aoColumns: [
					null,
					null,
					null,
					null,
					{
						"bSortable": false
					}
				]
			});

			window.dt = this.datatable;

			return this;
		},

		events: function() {
			var _self = this;

			this.$table
				.on('click', 'a.save-row', function(e) {
					e.preventDefault();

					_self.rowSave($(this).closest('tr'));
				})
				.on('click', 'a.cancel-row', function(e) {
					e.preventDefault();

					_self.rowCancel($(this).closest('tr'));
				})
				.on('click', 'a.edit-row', function(e) {
					e.preventDefault();

					_self.rowEdit($(this).closest('tr'));
				})
				.on('click', 'a.remove-row', function(e) {
//					alert(aa);
					e.preventDefault();
					var $row = $(this).closest('tr');
					var stateflag = $(this).attr('stateflag');
					var downpublishbankid = $row.attr('bankid');
					$.magnificPopup.open({
						items: {
							src: _self.options.dialog.wrapper,
							type: 'inline'
						},
						preloader: false,
						modal: true,
						callbacks: {
							change: function() {
								_self.dialog.$confirm.on('click', function(e) {
									e.preventDefault();
									$.ajax({
										url: "bankdownpublish",
										type: "get",
										data: {
											"downpublishbankid": downpublishbankid,
										},
										success: function(data) {
											//登录成功
											if(data.code == '0000') {
												//不直接删掉是防止，下一次上传到商城的时候状态改为零，但实际上已经有交易记录了，如果直接移除那么之前的交易记录就没有了
												if(stateflag == 0) {
													$('.alert').html('申请取消成功').addClass('alert-success').show().delay(1000).fadeOut();
												} else if(stateflag == 2) {
													$('.alert').html('取消发布成功').addClass('alert-success').show().delay(1000).fadeOut();
												} else if(stateflag == 1) {
													$('.alert').html('下架成功，此题库不再商城售卖。').addClass('alert-success').show().delay(1000).fadeOut();
												}
												_self.rowRemove($row);
											}
										},
										error: function() {
											$('.alert').html('网络错误，下架失败').addClass('alert-error').show().delay(1000).fadeOut();
										}
									});
									$.magnificPopup.close();
								});
							},
							close: function() {
								_self.dialog.$confirm.off('click');
							}
						}
					});

				});

			this.$addButton.on('click', function(e) {
				e.preventDefault();

				_self.rowAdd();
			});

			this.dialog.$cancel.on('click', function(e) {
				e.preventDefault();
				$.magnificPopup.close();
			});

			return this;
		},

		// ==========================================================================================
		// ROW FUNCTIONS
		// ==========================================================================================
		rowAdd: function() {
			this.$addButton.attr({
				'disabled': 'disabled'
			});

			var actions,
				data,
				$row;

			actions = [
				'<a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>',
				'<a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>',
				'<a href="#" class="on-default edit-row"><i class="fa fa-pencil"></i></a>',
				'<a href="#" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>'
			].join(' ');

			data = this.datatable.row.add(['', '', '', actions]);
			$row = this.datatable.row(data[0]).nodes().to$();

			$row
				.addClass('adding')
				.find('td:last')
				.addClass('actions');

			this.rowEdit($row);

			this.datatable.order([0, 'asc']).draw(); // always show fields
		},

		rowCancel: function($row) {
			var _self = this,
				$actions,
				i,
				data;

			if($row.hasClass('adding')) {
				this.rowRemove($row);
			} else {

				data = this.datatable.row($row.get(0)).data();
				this.datatable.row($row.get(0)).data(data);

				$actions = $row.find('td.actions');
				if($actions.get(0)) {
					this.rowSetActionsDefault($row);
				}

				this.datatable.draw();
			}
		},

		rowEdit: function($row) {
			var _self = this,
				data;

			data = this.datatable.row($row.get(0)).data();

			$row.children('td').each(function(i) {
				var $this = $(this);

				if($this.hasClass('actions')) {
					_self.rowSetActionsEditing($row);
				} else {
					$this.html('<input type="text" class="form-control input-block" value="' + data[i] + '"/>');
				}
			});
		},

		rowSave: function($row) {
			var _self = this,
				$actions,
				values = [];

			if($row.hasClass('adding')) {
				this.$addButton.removeAttr('disabled');
				$row.removeClass('adding');
			}

			values = $row.find('td').map(function() {
				var $this = $(this);

				if($this.hasClass('actions')) {
					_self.rowSetActionsDefault($row);
					return _self.datatable.cell(this).data();
				} else {
					return $.trim($this.find('input').val());
				}
			});

			this.datatable.row($row.get(0)).data(values);

			$actions = $row.find('td.actions');
			if($actions.get(0)) {
				this.rowSetActionsDefault($row);
			}

			this.datatable.draw();
		},

		rowRemove: function($row) {
			if($row.hasClass('adding')) {
				this.$addButton.removeAttr('disabled');
			}

			this.datatable.row($row.get(0)).remove().draw();
		},

		rowSetActionsEditing: function($row) {
			$row.find('.on-editing').removeClass('hidden');
			$row.find('.on-default').addClass('hidden');
		},

		rowSetActionsDefault: function($row) {
			$row.find('.on-editing').addClass('hidden');
			$row.find('.on-default').removeClass('hidden');
		}

	};

	$(function() {
		EditableTable.initialize();
	});

}).apply(this, [jQuery]);