import React, { Fragment, useState, useEffect } from 'react';
import { useLocation } from 'library/hooks/useLocation';
import Sticky from 'react-stickynode';
import { Row, Col, Modal, Button } from 'antd';
import { Container, Loader } from 'components/index';
import useWindowSize from 'library/hooks/useWindowSize';
import { useHistory } from 'react-router';
import isEmpty from 'lodash/isEmpty';
import { HallInformation, VerticalTab } from 'container/index';
import HallPageWrapper, { ButtonBox } from 'container/hall/HallDetail.style';
import axios from 'axios'
import { ADD_HALL_PAGE, UPDATE_HALL_PAGE } from 'settings/constant';
import { Link } from 'react-router-dom';

const HallDetail = ({ match }) => {
  const { href } = useLocation();
  const [isModalShowing, setIsModalShowing] = useState(false);
  const { width } = useWindowSize();
  const [ props ] = useState([])
  const [ hallDetail, setHallDetail ] = useState([])
  let history = useHistory();

  const URL = `http://localhost:8080/halls/find/`

  useEffect(e => {
    axios.get(URL+match.params.hallNum)
    .then(resp => {
      setHallDetail(resp.data)
    })
    .catch(err => {
      alert(`전시관 진입 실패`)
      throw err;
    })
  }, [])

  if (isEmpty(hallDetail)) return <Loader />;

  const deleteHall = e => {
    e.preventDefault()
    window.confirm("전시관을 삭제하시겠습니까?")
    axios({
      url: 'http://localhost:8080/halls/'+ match.params.hallNum,
      method: 'delete',
      headers: {
        'Content-Type'  : 'application/json',
        'Authorization' : 'Bearer '+localStorage.getItem("token")
      },
      data: { 
        hallNum: match.params.hallNum 
      }
    })
    .then(resp => {
      alert(`삭제 완료`)
      history.push('/')
    })
    .catch(err => {
      alert(`삭제 실패`)
      throw err;
    })
  }

  return (
    <HallPageWrapper>
      {/*  { localStorage.getItem("user").admin === '관리자' ?  */}
        <ButtonBox>
          <Link to={ADD_HALL_PAGE}>
          <button className="btn">등록</button>
          </Link>
          <Link to={`${UPDATE_HALL_PAGE}/${hallDetail.hallNum}`}>
          <button className="btn">수정</button>
          </Link>
          <button className="cancle-btn" onClick={ deleteHall }>삭제</button>
        </ButtonBox>
     {/*     : <></>
        }  */}
      <Container>
        <Row gutter={30}>
          <VerticalTab />
          <HallInformation
            title={hallDetail.hallName}
            content={hallDetail.hallInfo}
            time={hallDetail.hallTime}
            closedday={hallDetail.hallClosed}
            address={hallDetail.hallLocation}
            pnumber={hallDetail.hallPnumber}
            media={hallDetail.hallImage}
            num={hallDetail.hallNum}
          />
        </Row>
      </Container>
    </HallPageWrapper>
  );
};

export default HallDetail;