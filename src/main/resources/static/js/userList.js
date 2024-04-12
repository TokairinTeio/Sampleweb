/**
 * ユーザー一覧画面
 */
$(function(){
	$('#deleteOkBtn').click(function(){
		$('#deleteBtn').trigger('click');
	});
	//テーブルの行をクリックした時の処理
	$('#userList tbody tr').on('click',function(){
		//全ての行の選択状態を解除
	 $('#userList tbody tr').removeClass('table-active');
	 //クリックされた行に選択状態のクラスを追加	
	$(this).addClass('table-active');
	//更新ボタン、削除ボタンを活性化
	$('#updateBtn').removeAttr('disabled');
	$('#deleteDummyBtn').removeAttr('disabled');
	
	editSelectedLoginId($(this));
    });
    $('#deleteOkBtn').click(function(){
		$('#deleteBtn').trigger('click');
	});
    
 });
 /**
  * テーブルで選択された行のログインIDを画面のhiddenの要素に保管します。
  * @param row 選択された行情報
  */
 function editSelectedLoginId(row){
	row.find('td').each(function(){
		var columnId=$(this).attr('id');
		if(columnId.startsWith('loginId_')){
			$('#selectedLoginId').val($(this).text());
			return false;
		}
	});
 }
 
 
 
 
 
 
 
 