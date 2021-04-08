import React, { useState, useEffect } from 'react';
import { IoIosArrowBack } from 'react-icons/io';
import { useStateMachine } from 'little-state-machine';
import { useForm } from 'react-hook-form';
import { Button } from 'antd';
import { DragAndDropUploader, FormControl } from 'components/index';
import { AddListingAction } from 'container/index';
import { FormHeader, Title, FormContent, FormAction } from 'container/exhibition/AddExhibition.style';
import axios from 'axios'

const HotelPhotos = ({ setStep }) => {
  const { register, errors, setValue, handleSubmit } = useForm({});
  const [ exhbnImage, setExhbnImage ] = useState('')
  const { action, state } = useStateMachine(AddListingAction);

  const URL = 'http://localhost:8080/exhbns'

  const add = e => {
    e.preventDefault()
    const file = document.getElementById('exhbnImage');
    if (file.files.length > 0) {
      var formData = new FormData();
      formData.append('file', file.files[0]);
  
    axios.post(URL,{
      exhbnImage,
    })
    .then(resp => {
      alert(`포스터 등록 완료`)
      console.log(resp);
    })
    .catch(err => {
      alert(`포스터 등록 실패`)
      throw err;
    });
  }
}

  const onSubmit = (data) => {
    action(data);
    setStep(3);
    console.log(data)
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} id="form" method="post" action="/upload" enctype="multipart/form-data">
      <FormContent>
        <FormHeader>
          <Title>전시회 등록</Title>
        </FormHeader>
        <input
          name="file" id="exhbnImage" accept="image/*"
          type="file" ref={register}
/*           onChange={onChange} */ />
        {/* <FormControl
          error={errors.exhbnImage && <span>이 입력란을 작성해주세요!</span>}
        >
        </FormControl> */}
      </FormContent>
      <FormAction>
        <div className="inner-wrapper">
          <Button
            className="back-btn"
            htmlType="button"
            onClick={() => setStep(1)}
          >
            <IoIosArrowBack /> 뒤로가기
          </Button>
          <Button type="primary" htmlType="submit" onClick={e => add() } >
            등록하기
          </Button>
        </div>
      </FormAction>
    </form>
  );
};

export default HotelPhotos;
