/**
 * packageName :  com.nhnacademy.task.entity.pk
 * fileName : ProjectMemberPk
 * author :  ichunghui
 * date : 2023/06/06 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/06                ichunghui             최초 생성
 */

package com.nhnacademy.task.entity.pk;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class ProjectMemberPk implements Serializable {
    private Long projectMemberNum;
    private Long projectNum;
}